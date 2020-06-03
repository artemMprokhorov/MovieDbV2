package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import io.reactivex.Single

interface MovieRestApi {

    fun getPopular(pageNum: String?, apiKey: String?): Single<RemotePopular>

    fun getMovieItem(movieId: String?, apiKey: String?): Single<RemoteMovieItem>

}
