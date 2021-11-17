package com.example.moviedb.catalog.presentation.model

data class UiMovieItem(
    val title: String,
    val popularity: String,
    val voteCount: String,
    val voteAverage: String,
    val adult: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val backdropPath: String,
    val belongsToCollection: UiMovieItemBelongs,
    val budget: String,
    val genres: List<UiMovieItemGenre>,
    val homepage: String,
    val id: String,
    val imdbId: String,
    val posterPath: String,
    val productionCompanies: List<UiMovieItemProdComp>,
    val productionCountries: List<UiMovieItemProdCount>,
    val revenue: String,
    val spokenLanguages: List<UiMovieItemLang>,
    val status: String,
    val tagline: String,
    val video: String
)