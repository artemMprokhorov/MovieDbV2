package com.example.moviedb.catalog.data.source

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular

interface MovieRemote {

    suspend fun getPopular(pageNum: String, apiKey: String): RemotePopular

    suspend fun getMovieItem(movieId: String, apiKey: String): RemoteMovieItem
}