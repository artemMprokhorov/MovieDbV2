package com.example.moviedb.catalog.presentation

import com.example.moviedb.catalog.presentation.model.UiMovieItem
import com.example.moviedb.catalog.presentation.model.UiPopular


sealed class MovieState(
    val isLoading: Boolean = false
) {

    object DefaultState : MovieState()

    object LoadingState : MovieState()

    data class SuccessPopularState(val popular: UiPopular) : MovieState()

    data class ErrorState(val error: Throwable) : MovieState()

    data class SuccessItemSelectedState(val uiMovieItem: UiMovieItem) : MovieState()

}