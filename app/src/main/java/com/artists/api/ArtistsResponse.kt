package com.artists.api

import com.google.gson.annotations.SerializedName


data class ArtistsResponse(

    @SerializedName("artists")
    val artists: ArtistResponse

) {
    data class ArtistResponse(

        @SerializedName("artist")
        val artist: List<Artist> = emptyList()

    )
}