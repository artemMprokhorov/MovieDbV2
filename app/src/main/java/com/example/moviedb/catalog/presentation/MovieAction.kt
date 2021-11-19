package com.example.moviedb.catalog.presentation

import com.example.moviedb.commons.mvi.MviAction

sealed class MovieAction : MviAction {

    class GetPopularAction(val pageNum: String) : MovieAction()

    class GetItemSelectedAction(val movieId: String) : MovieAction()
}