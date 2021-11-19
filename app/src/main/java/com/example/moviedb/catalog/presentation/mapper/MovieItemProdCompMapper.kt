package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemProdComp
import com.example.moviedb.catalog.presentation.model.MovieItemProdComp
import javax.inject.Inject

class MovieItemProdCompMapper @Inject constructor() {

    fun RemoteMovieItemProdComp.toPresentation() = MovieItemProdComp(
        id = id.orEmpty(),
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty()
    )
}