package com.example.moviedb.catalog.presentation.result

import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.domain.model.DomainPopular


sealed class MovieResult {

    sealed class GetMovieResult : MovieResult() {
        object InProgress : GetMovieResult()
        data class Success(val state: DomainPopular) : GetMovieResult()
        data class Error(val error: Throwable) : GetMovieResult()
    }

    sealed class GetMovieLoadingResult : MovieResult() {
        object InProgress : GetMovieLoadingResult()
        data class Success(val domainMovieItem: DomainMovieItem) : GetMovieLoadingResult()
        data class Error(val error: Throwable) : GetMovieLoadingResult()
    }

}