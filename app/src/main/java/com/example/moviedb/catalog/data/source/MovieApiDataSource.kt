package com.example.moviedb.catalog.data.source

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.data.remote.MovieRestApi
import io.reactivex.Single
import javax.inject.Inject

class MovieApiDataSource @Inject constructor(
    private val movieRestApi: MovieRestApi
) : MovieDataSource {

    override fun getPopular(pageNum: String?, apiKey: String?): Single<RemotePopular> {
        return movieRestApi.getPopular(pageNum, apiKey)
    }

    override fun getMovieItem(
        movieId: String?,
        apiKey: String?
    ): Single<RemoteMovieItem> {
        return movieRestApi.getMovieItem(movieId, apiKey)
    }

}
