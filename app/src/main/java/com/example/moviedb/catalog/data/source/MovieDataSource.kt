package com.example.moviedb.catalog.data.source

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import io.reactivex.Single

interface MovieDataSource {

    fun getPopular(pageNum: String, apiKey: String): Single<RemotePopular>

    fun getMovieItem(movieId: String, apiKey: String): Single<RemoteMovieItem>
}