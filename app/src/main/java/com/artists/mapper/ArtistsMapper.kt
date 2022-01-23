package com.artists.mapper

import com.artists.api.Artist
import com.artists.storage.entity.ArtistDb

interface ArtistsMapper : Mapper<ArtistDb, Artist> {
    override fun ArtistDb.toRemote(): Artist {
        return Artist(
            name = name,
            playcount = playcount,
            listeners = listeners,
            mbid = mbid,
            url = url,
            streamable = streamable,
            image = listOf(Artist.Image(image, ""))
        )
    }

    override fun Artist.toStorage(): ArtistDb {
        return ArtistDb(
            name = name,
            playcount = playcount,
            listeners = listeners,
            mbid = mbid,
            url = url,
            streamable = streamable,
            image = image[image.size - 1].url
        )
    }
}