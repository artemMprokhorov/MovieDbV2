package com.example.moviedb.catalog.presentation

import com.example.moviedb.catalog.presentation.model.MovieItem
import com.example.moviedb.catalog.presentation.model.Popular
import com.example.moviedb.commons.mvi.MviState

sealed class MovieState : MviState {

    object DefaultState : MovieState()

    object LoadingState : MovieState()

    data class SuccessPopularState(val popular: Popular) : MovieState()

    data class ErrorState(val error: Throwable) : MovieState()

    data class SuccessItemSelectedState(val movieItem: MovieItem) : MovieState()
}