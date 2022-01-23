package com.artists.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artists.storage.entity.ArtistDb.Artists.Column
import com.artists.storage.entity.ArtistDb.Artists.tableName

@Entity(tableName = tableName)
data class ArtistDb(

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        @ColumnInfo(name = Column.name)
        val name: String? = null,

        @ColumnInfo(name = Column.playcount)
        val playcount: String? = null,

        @ColumnInfo(name = Column.listeners)
        val listeners: String? = null,

        @ColumnInfo(name = Column.mbid)
        val mbid: String? = null,

        @ColumnInfo(name = Column.url)
        val url: String? = null,

        @ColumnInfo(name = Column.streamable)
        val streamable: String? = null,

        @ColumnInfo(name = Column.image)
        val image: String? = null
) {

    object Artists {
        const val tableName = "artists"

        object Column {
            const val id = "id"
            const val name = "name"
            const val playcount = "playcount"
            const val listeners = "listeners"
            const val mbid = "mbid"
            const val url = "url"
            const val streamable = "streamable"
            const val image = "image"
        }
    }
}