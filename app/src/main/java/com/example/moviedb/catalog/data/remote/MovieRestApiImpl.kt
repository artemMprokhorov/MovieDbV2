package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.data.source.MovieDataSource
import io.reactivex.Single
import javax.inject.Inject

class MovieRestApiImpl @Inject constructor(
    private val restApi: MovieRestApi
) : MovieDataSource {


    override fun getPopular(pageNum: String, apiKey: String): Single<RemotePopular> {
        return restApi.getPopular(apiKey, pageNum)
    }

    override fun getMovieItem(
        movieId: String,
        apiKey: String
    ): Single<RemoteMovieItem> {
        return restApi.getMovieItem(movieId, apiKey)
    }
}
