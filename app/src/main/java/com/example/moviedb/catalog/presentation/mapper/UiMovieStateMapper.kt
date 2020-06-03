package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainPopular
import com.example.moviedb.catalog.presentation.model.UiPopular
import javax.inject.Inject

class UiMovieStateMapper @Inject constructor() {

    fun DomainPopular.fromDomainToUi(uiStateItemMapper: UiStateItemMapper) = UiPopular(
        page = page,
        total_results = total_results,
        total_pages = total_pages,
        results = results?.map {
            with(uiStateItemMapper) {
                it.fromDomainToUi()
            }
        }
    )

}