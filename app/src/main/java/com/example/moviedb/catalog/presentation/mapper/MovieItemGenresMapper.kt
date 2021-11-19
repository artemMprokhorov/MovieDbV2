package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemGenre
import com.example.moviedb.catalog.presentation.model.MovieItemGenre
import javax.inject.Inject

class MovieItemGenresMapper @Inject constructor() {

    fun RemoteMovieItemGenre.toPresentation() = MovieItemGenre(
        id = id.orEmpty(),
        name = name.orEmpty()
    )
}