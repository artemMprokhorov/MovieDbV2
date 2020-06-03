package com.example.moviedb.catalog.domain.repo

import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.domain.model.DomainPopular
import io.reactivex.Single

interface MovieRepository {

    fun getPopular(pageNum: String?): Single<DomainPopular>

    fun getMovieItem(movieId: String?): Single<DomainMovieItem>

}