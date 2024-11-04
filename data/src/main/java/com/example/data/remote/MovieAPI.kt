package com.example.data.remote

import com.example.data.remote.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie")
    @Headers("X-API-KEY: EZZEF6Q-QEDM0G7-QQ1A9TY-JT6089H")
    suspend fun getMovies(
        @Query("selectFields") id: String = "id",
        @Query("selectFields") name: String = "name",
        @Query("selectFields") year: String = "year",
        @Query("selectFields") poster: String = "poster",
        @Query("notNullFields") url: String = "poster.url",
        @Query("notNullFields") rating: String = "rating.imdb",
        @Query("notNullFields") description: String = "description",
        @Query("type") type: String = "anime"
    ): Response<MoviesResponse>

    @GET("movie")
    @Headers("X-API-KEY: EZZEF6Q-QEDM0G7-QQ1A9TY-JT6089H")
    suspend fun getMovie(
        @Query("id") idMovie: Int,
        @Query("selectFields") id: String = "id",
        @Query("selectFields") description: String = "description",
        @Query("selectFields") rating: String = "rating",
        @Query("selectFields") name: String = "name",
        @Query("selectFields") year: String = "year",
        @Query("selectFields") poster: String = "poster",
    ): Response<MoviesResponse>
}