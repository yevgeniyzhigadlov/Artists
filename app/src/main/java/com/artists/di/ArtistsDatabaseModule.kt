package com.artists.di

import android.app.Application
import com.artists.storage.ArtistsDao
import com.artists.storage.ArtistsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ArtistsDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): ArtistsDatabase = ArtistsDatabase.build(app)

    @Singleton
    @Provides
    fun provideDao(db: ArtistsDatabase): ArtistsDao = db.artistsDao()
}