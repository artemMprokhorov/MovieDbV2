package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemotePopular
import com.example.moviedb.catalog.domain.model.DomainPopular
import javax.inject.Inject

class PopularMapper @Inject constructor() {

    fun RemotePopular.fromRemoteToDomain(popularItemMapper: PopularItemMapper): DomainPopular =
        DomainPopular(
            page = page,
            total_results = total_results,
            total_pages = total_pages,
            results = results?.map {
                with(popularItemMapper) {
                    it.fromRemoteToDomain()
                }
            }
        )
}