package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemProdCount
import com.example.moviedb.catalog.presentation.model.UiMovieItemProdCount
import javax.inject.Inject

class UiMovieItemProdCountMapper @Inject constructor() {

    fun DomainMovieItemProdCount.fromDomainToUi(): UiMovieItemProdCount = UiMovieItemProdCount(
        iso = iso,
        name = name

    )
}