package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.domain.model.DomainPopular
import javax.inject.Inject

class PopularMapper @Inject constructor() {

    fun RemotePopular.fromRemoteToDomain(popularItemMapper: PopularItemMapper) =
        DomainPopular(
            page = page ?: 0,
            totalResults = totalResults ?: 0,
            totalPages = totalPages ?: 0,
            results = results?.map {
                with(popularItemMapper) {
                    it.toDomain()
                }
            }.orEmpty()
        )
}