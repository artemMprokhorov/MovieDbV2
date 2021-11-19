package com.example.moviedb.catalog.presentation.model

data class MovieItem(
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
    val belongsToCollection: MovieItemBelongs,
    val budget: String,
    val genres: List<MovieItemGenre>,
    val homepage: String,
    val id: String,
    val imdbId: String,
    val posterPath: String,
    val productionCompanies: List<MovieItemProdComp>,
    val productionCountries: List<MovieItemProdCount>,
    val revenue: String,
    val spokenLanguages: List<MovieItemLang>,
    val status: String,
    val tagline: String,
    val video: String
)