package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemProdComp
import com.example.moviedb.catalog.domain.model.DomainMovieItemProdComp
import javax.inject.Inject

class MovieItemProdCompMapper @Inject constructor() {

    fun RemoteMovieItemProdComp.toDomain() = DomainMovieItemProdComp(
        id = id.orEmpty(),
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty()
    )
}