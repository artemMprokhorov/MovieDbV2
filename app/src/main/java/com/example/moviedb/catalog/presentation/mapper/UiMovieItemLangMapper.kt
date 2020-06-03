package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemLang
import com.example.moviedb.catalog.presentation.model.UiMovieItemLang
import javax.inject.Inject

class UiMovieItemLangMapper @Inject constructor() {

    fun DomainMovieItemLang.fromDomainToUi(): UiMovieItemLang = UiMovieItemLang(
        iso = iso,
        name = name
    )
}