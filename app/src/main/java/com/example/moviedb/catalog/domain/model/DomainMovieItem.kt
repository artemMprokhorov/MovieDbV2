package com.example.moviedb.catalog.domain.model

data class DomainMovieItem(
    val adult: String?,
    val backdrop_path: String?,
    val belongs_to_collection: DomainMovieItemBelongs?,
    val budget: String?,
    val genres: List<DomainMovieItemGenre>?,
    val homepage: String?,
    val id: String?,
    val imdb_id: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: String?,
    val poster_path: String?,
    val production_companies: List<DomainMovieItemProdComp>?,
    val production_countries: List<DomainMovieItemProdCount>?,
    val release_date: String?,
    val revenue: String?,
    val spoken_languages: List<DomainMovieItemLang>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: String?,
    val vote_average: String?,
    val vote_count: String?

)