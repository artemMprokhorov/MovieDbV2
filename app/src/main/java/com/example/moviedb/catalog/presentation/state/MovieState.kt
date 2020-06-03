package com.example.moviedb.catalog.presentation.state

import com.example.moviedb.catalog.presentation.model.UiMovieItem
import com.example.moviedb.catalog.presentation.model.UiPopular


sealed class MovieState(
    val isLoading: Boolean = false
) {

    object Default : MovieState()

    object Loading : MovieState(
        isLoading = true
    )

    data class SuccessState(val popular: UiPopular) : MovieState()

    data class Error(val presentationError: Throwable) : MovieState()

    data class SuccessMovieLoading(val uiMovieItem: UiMovieItem) : MovieState()

}