package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemotePopularItem
import com.example.moviedb.catalog.domain.model.DomainPopularItem
import javax.inject.Inject

class PopularItemMapper @Inject constructor() {

    fun RemotePopularItem.fromRemoteToDomain(): DomainPopularItem = DomainPopularItem(
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )
}