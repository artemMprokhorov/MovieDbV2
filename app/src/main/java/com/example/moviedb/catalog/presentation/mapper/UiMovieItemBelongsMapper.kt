package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemBelongs
import com.example.moviedb.catalog.presentation.model.UiMovieItemBelongs
import javax.inject.Inject

class UiMovieItemBelongsMapper @Inject constructor() {

    fun DomainMovieItemBelongs.fromDomainToUi(): UiMovieItemBelongs = UiMovieItemBelongs(
        id = id,
        name = name,
        backdrop_path = backdrop_path,
        poster_path = poster_path
    )
}