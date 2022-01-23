package com.artists.api

import com.google.gson.annotations.SerializedName

data class Artist(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("playcount")
    val playcount: String? = null,

    @SerializedName("listeners")
    val listeners: String? = null,

    @SerializedName("mbid")
    val mbid: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("streamable")
    val streamable: String? = null,

    @SerializedName("image")
    val image: List<Image> = emptyList()

) {
    data class Image(

        @SerializedName("#text")
        val url: String? = null,

        @SerializedName("size")
        val size: String? = null
    )
}