package com.example.moviedb.catalog.presentation.model

data class Popular(
    val page: Long,
    val totalResults: Long,
    val totalPages: Long,
    val results: List<PopularItem>
)