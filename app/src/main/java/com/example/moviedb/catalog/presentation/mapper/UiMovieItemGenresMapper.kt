package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemGenre
import com.example.moviedb.catalog.presentation.model.UiMovieItemGenre
import javax.inject.Inject

class UiMovieItemGenresMapper @Inject constructor() {

    fun DomainMovieItemGenre.toUi() = UiMovieItemGenre(
        id = id,
        name = name
    )
}