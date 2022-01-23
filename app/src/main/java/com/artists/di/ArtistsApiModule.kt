package com.artists.di

import com.artists.api.ArtistsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ArtistsApiModule {

    @Singleton
    @Provides
    fun provideArtistsApi(retrofit: Retrofit): ArtistsApi = retrofit.create(ArtistsApi::class.java)
}