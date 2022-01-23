package com.artists.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.artists.storage.entity.ArtistDb
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistsDao {

    @Insert
    fun insertArtists(artists: List<ArtistDb>): List<Long>

    @Query("DELETE FROM artists")
    fun clearAllArtists()

    @Transaction
    fun clearAndCacheArtists(artists: List<ArtistDb>) {
        clearAllArtists()
        insertArtists(artists)
    }

    @Query("SELECT * FROM artists")
    fun getAllArtists(): Flow<List<ArtistDb>>
}