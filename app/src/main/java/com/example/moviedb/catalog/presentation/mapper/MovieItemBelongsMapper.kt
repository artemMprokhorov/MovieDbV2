package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.model.RemoteMovieItemBelongs
import com.example.moviedb.catalog.presentation.model.MovieItemBelongs
import javax.inject.Inject

class MovieItemBelongsMapper @Inject constructor() {

    fun RemoteMovieItemBelongs.toPresentation() = MovieItemBelongs(
        id = id.orEmpty(),
        name = name.orEmpty(),
        backdropPath = BuildConfig.API_IMG + backdropPath.orEmpty(),
        posterPath = posterPath.orEmpty()
    )

    fun makeDefaultMovieItemBelongs() = MovieItemBelongs(
        id = "",
        name = "",
        backdropPath = "",
        posterPath = ""
    )
}