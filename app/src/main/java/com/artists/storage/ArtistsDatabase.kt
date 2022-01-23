package com.artists.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artists.storage.entity.ArtistDb

@Database(
        entities = [ArtistDb::class],
        version = 1
//        version = ArtistsDatabaseMigration.latestVersion
)
abstract class ArtistsDatabase : RoomDatabase() {

    abstract fun artistsDao(): ArtistsDao

    companion object {

        private const val databaseName = "artists-db"

        fun build(context: Context) =
                Room.databaseBuilder(context, ArtistsDatabase::class.java, databaseName)
                    .build()
    }
}