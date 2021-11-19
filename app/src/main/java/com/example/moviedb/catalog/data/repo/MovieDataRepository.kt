package com.example.moviedb.catalog.data.repo

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.data.source.MovieRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val remote: MovieRemote
) {

    fun getPopular(pageNum: String): Flow<RemotePopular> = flow {
        emit(remote.getPopular(pageNum, getApiKey()))
    }

    fun getMovieItem(movieId: String): Flow<RemoteMovieItem> = flow {
        emit(remote.getMovieItem(movieId, getApiKey()))
    }

    private fun getApiKey(): String = BuildConfig.API_KEY
}