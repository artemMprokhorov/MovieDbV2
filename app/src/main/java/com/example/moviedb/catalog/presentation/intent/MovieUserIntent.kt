package com.example.moviedb.catalog.presentation.intent

sealed class MovieUserIntent {

    class InitialUserIntent(val pageNum: String?) : MovieUserIntent()

    class MovieLoadingUserIntent(val movieId: String?) : MovieUserIntent()

}