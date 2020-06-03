package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemProdComp
import com.example.moviedb.catalog.domain.model.DomainMovieItemProdComp
import javax.inject.Inject

class MovieItemProdCompMapper @Inject constructor() {

    fun RemoteMovieItemProdComp.fromRemoteToDomain(): DomainMovieItemProdComp =
        DomainMovieItemProdComp(
            id = id,
            logo_path = logo_path,
            name = name,
            origin_country = origin_country

        )
}