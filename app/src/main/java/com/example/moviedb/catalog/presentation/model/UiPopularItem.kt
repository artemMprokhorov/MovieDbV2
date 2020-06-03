package com.example.moviedb.catalog.presentation.model

data class UiPopularItem(
    val popularity: String?,
    val voteCount: Long?,
    val video: Boolean?,
    val posterPath: String?,
    val id: String?,
    val adult: String?,
    val backdropPath: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val title: String?,
    val voteAverage: String?,
    val overview: String?,
    val releaseDate: String?
)