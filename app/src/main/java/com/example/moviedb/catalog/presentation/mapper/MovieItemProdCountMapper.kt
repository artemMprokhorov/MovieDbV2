package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemProdCount
import com.example.moviedb.catalog.presentation.model.MovieItemProdCount
import javax.inject.Inject

class MovieItemProdCountMapper @Inject constructor() {

    fun RemoteMovieItemProdCount.toPresentation() = MovieItemProdCount(
        iso = iso.orEmpty(),
        name = name.orEmpty()
    )
}