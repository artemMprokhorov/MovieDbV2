package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.data.source.MovieRemote
import javax.inject.Inject

class MovieRestApiImpl @Inject constructor(
    private val restApi: MovieRestApi
) : MovieRemote {

    override suspend fun getPopular(pageNum: String, apiKey: String): RemotePopular =
        restApi.getPopular(apiKey, pageNum)

    override suspend fun getMovieItem(movieId: String, apiKey: String): RemoteMovieItem =
        restApi.getMovieItem(movieId, apiKey)
}
