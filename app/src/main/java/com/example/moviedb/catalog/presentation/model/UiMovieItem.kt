package com.example.moviedb.catalog.presentation.model

data class UiMovieItem(
    val title: String?,
    val popularity: String?,
    val vote_count: String?,
    val vote_average: String?,
    val adult: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val release_date: String?,
    val backdrop_path: String?,
    val belongs_to_collection: UiMovieItemBelongs?,
    val budget: String?,
    val genres: List<UiMovieItemGenre>?,
    val homepage: String?,
    val id: String?,
    val imdb_id: String?,
    val poster_path: String?,
    val production_companies: List<UiMovieItemProdComp>?,
    val production_countries: List<UiMovieItemProdCount>?,
    val revenue: String?,
    val spoken_languages: List<UiMovieItemLang>?,
    val status: String?,
    val tagline: String?,
    val video: String?


)