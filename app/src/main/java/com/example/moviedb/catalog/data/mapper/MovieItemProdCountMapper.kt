package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemProdCount
import com.example.moviedb.catalog.domain.model.DomainMovieItemProdCount
import javax.inject.Inject

class MovieItemProdCountMapper @Inject constructor() {

    fun RemoteMovieItemProdCount.fromRemoteToDomain() = DomainMovieItemProdCount(
        iso = iso.orEmpty(),
        name = name.orEmpty()
    )
}