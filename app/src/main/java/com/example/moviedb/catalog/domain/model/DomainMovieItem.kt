package com.example.moviedb.catalog.domain.model

data class DomainMovieItem(
    val adult: String,
    val backdropPath: String,
    val belongsToCollection: DomainMovieItemBelongs,
    val budget: String,
    val genres: List<DomainMovieItemGenre>,
    val homepage: String,
    val id: String,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: String,
    val posterPath: String,
    val productionCompanies: List<DomainMovieItemProdComp>,
    val productionCountries: List<DomainMovieItemProdCount>,
    val releaseDate: String,
    val revenue: String,
    val spokenLanguages: List<DomainMovieItemLang>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: String,
    val voteAverage: String,
    val voteCount: String

)