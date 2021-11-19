package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemLang
import com.example.moviedb.catalog.presentation.model.MovieItemLang
import javax.inject.Inject

class MovieItemLangMapper @Inject constructor() {

    fun RemoteMovieItemLang.toPresentation() = MovieItemLang(
        iso = iso.orEmpty(),
        name = name.orEmpty()
    )
}