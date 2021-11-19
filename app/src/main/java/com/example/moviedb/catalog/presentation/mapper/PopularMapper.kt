package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.presentation.model.Popular
import javax.inject.Inject

class PopularMapper @Inject constructor() {

    fun RemotePopular.toPresentation(popularItemMapper: PopularItemMapper) = Popular(
        page = page ?: 0,
        totalResults = totalResults ?: 0,
        totalPages = totalPages ?: 0,
        results = results?.map {
            with(popularItemMapper) {
                it.toPresentation()
            }
        }.orEmpty()
    )
}