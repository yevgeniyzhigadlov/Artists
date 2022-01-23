package com.artists.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistsApi {

    @GET("2.0/")
    suspend fun getArtistsList(
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<ArtistsResponse>

}
