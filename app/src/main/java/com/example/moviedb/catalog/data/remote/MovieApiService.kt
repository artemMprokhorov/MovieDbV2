package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("/3/movie/popular")
    fun getPopular(
        @Query("api_key") key: String?,
        @Query("page") page: String?
    ): Single<RemotePopular>


    @GET("/3/movie/{key}")
    fun getMovieItem(
        @Path("key") movieId: String?,
        @Query("api_key") key: String?

    ): Single<RemoteMovieItem>

}