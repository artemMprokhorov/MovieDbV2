package com.example.moviedb.catalog.domain.model

open class DomainPopular(
    val page: Long?,
    val total_results: Long?,
    val total_pages: Long?,
    val results: List<DomainPopularItem>?
)