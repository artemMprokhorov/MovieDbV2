package com.example.moviedb.catalog.presentation.model

data class UiPopular(
    val page: Long,
    val totalResults: Long,
    val totalPages: Long,
    val results: List<UiPopularItem>
)