package com.artists.repository

import com.artists.BuildConfig
import com.artists.core.ui.ViewState
import com.artists.core.utils.httpError
import com.artists.mapper.ArtistsMapper
import com.artists.api.ArtistsResponse
import com.artists.api.ArtistsApi
import com.artists.storage.ArtistsDao
import com.artists.storage.entity.ArtistDb
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface ArtistsRepository {

    fun getAllArtists(): Flow<ViewState<List<ArtistDb>>>
    suspend fun getAllArtistsFromApi(): Response<ArtistsResponse>
}

@Singleton
class DefaultArtistsRepository @Inject constructor(
    private val artistsDao: ArtistsDao,
    private val artistsApi: ArtistsApi
) : ArtistsRepository, ArtistsMapper {

    override fun getAllArtists(): Flow<ViewState<List<ArtistDb>>> = flow {
        emit(ViewState.loading())

        val artistsFromApi = getAllArtistsFromApi()
        artistsFromApi.body()?.artists?.artist?.toStorage()?.let(artistsDao::clearAndCacheArtists)

        val cachedArtists = artistsDao.getAllArtists()
        emitAll(cachedArtists.map { ViewState.success(it) })
    }.flowOn(Dispatchers.IO)

    override suspend fun getAllArtistsFromApi(): Response<ArtistsResponse> {
        return try {
            artistsApi.getArtistsList(
                "chart.gettopartists",
                BuildConfig.API_KEY,
                "json",
                1,
                50
            )
        } catch (e: Exception) {
            httpError(404)
        }
    }
}

@Module
@InstallIn(ApplicationComponent::class)
interface ArtistsRepositoryModule {
    @Binds
    fun it(it: DefaultArtistsRepository): ArtistsRepository
}