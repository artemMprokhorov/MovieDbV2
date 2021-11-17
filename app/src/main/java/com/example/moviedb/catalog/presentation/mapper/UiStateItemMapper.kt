package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainPopularItem
import com.example.moviedb.catalog.presentation.model.UiPopularItem
import javax.inject.Inject

class UiStateItemMapper @Inject constructor() {

    fun DomainPopularItem.toUi() = UiPopularItem(
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