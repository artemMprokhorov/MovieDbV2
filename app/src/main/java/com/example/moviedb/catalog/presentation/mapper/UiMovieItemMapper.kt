package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.presentation.model.UiMovieItem
import javax.inject.Inject

class UiMovieItemMapper @Inject constructor() {

    fun DomainMovieItem.toUi(
        uiMovieItemLangMapper: UiMovieItemLangMapper,
        uiMovieItemProdCountMapper: UiMovieItemProdCountMapper,
        uiMovieItemProdCompMapper: UiMovieItemProdCompMapper,
        uiMovieItemGenresMapper: UiMovieItemGenresMapper,
        uiMovieItemBelongsMapper: UiMovieItemBelongsMapper
    ) = UiMovieItem(
        adult = adult,
        backdropPath = BuildConfig.API_IMG + backdropPath,
        belongsToCollection =
        with(uiMovieItemBelongsMapper) {
            belongsToCollection.toUi()

        },
        budget = budget,
        genres = genres.map {
            with(uiMovieItemGenresMapper) {
                it.toUi()
            }
        },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies.map {
            with(uiMovieItemProdCompMapper) {
                it.toUi()
            }
        },
        productionCountries = productionCountries.map {
            with(uiMovieItemProdCountMapper) {
                it.toUi()
            }
        },
        releaseDate = releaseDate,
        revenue = revenue,
        spokenLanguages = spokenLanguages.map {
            with(uiMovieItemLangMapper) {
                it.toUi()
            }
        },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}