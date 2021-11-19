package com.example.moviedb.catalog.presentation

import com.example.moviedb.catalog.presentation.model.MovieItem
import com.example.moviedb.catalog.presentation.model.Popular
import com.example.moviedb.commons.mvi.MviResult

sealed class MovieResult : MviResult {

    sealed class GetPopularResult : MovieResult() {
        object InProgress : GetPopularResult()
        data class Success(val popular: Popular) : GetPopularResult()
        data class Error(val error: Throwable) : GetPopularResult()
    }

    sealed class GetItemSelectedResult : MovieResult() {
        object InProgress : GetItemSelectedResult()
        data class Success(val movieItem: MovieItem) : GetItemSelectedResult()
        data class Error(val error: Throwable) : GetItemSelectedResult()
    }
}