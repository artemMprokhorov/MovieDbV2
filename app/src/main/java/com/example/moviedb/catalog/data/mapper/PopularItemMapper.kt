package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemotePopularItem
import com.example.moviedb.catalog.domain.model.DomainPopularItem
import javax.inject.Inject

class PopularItemMapper @Inject constructor() {

    fun RemotePopularItem.toDomain() = DomainPopularItem(
        popularity = popularity.orEmpty(),
        voteCount = voteCount?.toString() ?: "",
        video = video ?: false,
        posterPath = posterPath.orEmpty(),
        id = id.orEmpty(),
        adult = adult.orEmpty(),
        backdropPath = backdropPath.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        title = title.orEmpty(),
        voteAverage = voteAverage.orEmpty(),
        overview = overview.orEmpty(),
        releaseDate = releaseDate.orEmpty()
    )
}