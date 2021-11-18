package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.domain.model.DomainMovieItemBelongs
import com.example.moviedb.catalog.presentation.model.UiMovieItemBelongs
import javax.inject.Inject

class UiMovieItemBelongsMapper @Inject constructor() {

    fun DomainMovieItemBelongs.toUi() = UiMovieItemBelongs(
        id = id,
        name = name,
        backdropPath = BuildConfig.API_IMG + backdropPath,
        posterPath = posterPath
    )
}