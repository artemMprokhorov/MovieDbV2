package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemProdComp
import com.example.moviedb.catalog.presentation.model.UiMovieItemProdComp
import javax.inject.Inject

class UiMovieItemProdCompMapper @Inject constructor() {

    fun DomainMovieItemProdComp.toUi() = UiMovieItemProdComp(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}