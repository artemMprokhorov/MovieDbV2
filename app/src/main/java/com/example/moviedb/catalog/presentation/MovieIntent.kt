package com.example.moviedb.catalog.presentation

import com.example.moviedb.commons.mvi.MviIntent

sealed class MovieIntent : MviIntent {

    class GetPopularIntent(val pageNum: String) : MovieIntent()

    class GetItemSelectedIntent(val movieId: String) : MovieIntent()
}