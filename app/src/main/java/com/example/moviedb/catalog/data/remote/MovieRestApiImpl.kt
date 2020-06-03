package com.example.moviedb.catalog.data.remote

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.common.network.ApiClient
import io.reactivex.Single

class MovieRestApiImpl : ApiClient<MovieApiService>(), MovieRestApi {

    init {
        createService()
    }

    override fun getPopular(pageNum: String?, apiKey: String?): Single<RemotePopular> {
        return apiService?.getPopular(apiKey, pageNum)!!
    }

    override fun getMovieItem(
        movieId: String?,
        apiKey: String?
    ): Single<RemoteMovieItem> {
        return apiService?.getMovieItem(movieId, apiKey)!!
    }


    override fun getApiService(): Class<MovieApiService>? {
        return MovieApiService::class.java
    }

}
