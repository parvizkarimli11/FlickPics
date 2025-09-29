package com.example.flickipics.data.api

import com.example.flickipics.data.response.MovieListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieService {

    //    @Headers(
//        "accept: application/json", "X-API-KEY: FHB8JY6-C934M8C-JJVNWB1-FEHE2C8"
//    )
    @GET("movie")
    suspend fun fetchMovieList(
        @Query("limit") limit: Int = 5,
        @Query("page") page: Int = 1,
        @Query("notNullFields") notNullFields: String = "id",
        @Query("sortField") sortField: String = "id",
        @Query("sortType") sortType: Int = 1,
        @Query("type") type: String = "movie",
        @Query("selectFields") selectFields: List<String> = listOf(
            "id",
            "name",
            "enName",
            "genres",
            "poster",
            "logo"
        )
    ): Response<MovieListResponse>

}