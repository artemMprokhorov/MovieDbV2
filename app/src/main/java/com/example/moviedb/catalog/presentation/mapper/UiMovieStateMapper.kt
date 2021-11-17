package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainPopular
import com.example.moviedb.catalog.presentation.model.UiPopular
import javax.inject.Inject

class UiMovieStateMapper @Inject constructor() {

    fun DomainPopular.toUi(uiStateItemMapper: UiStateItemMapper) = UiPopular(
        page = page,
        totalResults = totalResults,
        totalPages = totalPages,
        results = results.map {
            with(uiStateItemMapper) {
                it.toUi()
            }
        }
    )
}