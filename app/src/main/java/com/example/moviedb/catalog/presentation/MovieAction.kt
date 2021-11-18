package com.example.moviedb.catalog.presentation

sealed class MovieAction {

    class Movie(val pageNum: String) : MovieAction()

    class MovieLoading(val movieId: String) : MovieAction()
}