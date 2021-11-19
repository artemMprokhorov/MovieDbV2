package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.model.RemotePopularItem
import com.example.moviedb.catalog.presentation.model.PopularItem
import javax.inject.Inject

class PopularItemMapper @Inject constructor() {

    fun RemotePopularItem.toPresentation() = PopularItem(
        popularity = popularity.orEmpty(),
        voteCount = voteCount?.toString() ?: "",
        video = video ?: false,
        posterPath = posterPath.orEmpty(),
        id = id.orEmpty(),
        adult = adult.orEmpty(),
        backdropPath = BuildConfig.API_IMG + backdropPath,
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        title = title.orEmpty(),
        voteAverage = voteAverage.orEmpty(),
        overview = overview.orEmpty(),
        releaseDate = releaseDate.orEmpty()
    )
}