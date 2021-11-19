package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRestApi {

    @GET("/3/movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String,
        @Query("page") page: String
    ): RemotePopular


    @GET("/3/movie/{key}")
    suspend fun getMovieItem(
        @Path("key") movieId: String,
        @Query("api_key") key: String
    ): RemoteMovieItem
}