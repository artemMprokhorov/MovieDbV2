package com.example.moviedb.catalog.presentation.model

data class UiPopular(
    val page: Long?,
    val total_results: Long?,
    val total_pages: Long?,
    val results: List<UiPopularItem>?
)