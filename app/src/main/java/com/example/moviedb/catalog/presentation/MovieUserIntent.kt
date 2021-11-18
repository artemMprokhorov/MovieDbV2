package com.example.moviedb.catalog.presentation

sealed class MovieUserIntent {

    class InitialUserIntent(val pageNum: String) : MovieUserIntent()

    class MovieLoadingUserIntent(val movieId: String) : MovieUserIntent()
}