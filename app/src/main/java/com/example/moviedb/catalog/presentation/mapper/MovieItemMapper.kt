package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.presentation.model.MovieItem
import javax.inject.Inject

class MovieItemMapper @Inject constructor() {

    fun RemoteMovieItem.toPresentation(
        movieItemLangMapper: MovieItemLangMapper,
        movieItemProdCountMapper: MovieItemProdCountMapper,
        movieItemProdCompMapper: MovieItemProdCompMapper,
        movieItemGenresMapper: MovieItemGenresMapper,
        movieItemBelongsMapper: MovieItemBelongsMapper
    ) = MovieItem(
        adult = adult.orEmpty(),
        backdropPath = BuildConfig.API_IMG + backdropPath,
        belongsToCollection = with(movieItemBelongsMapper) {
            belongsToCollection?.toPresentation()
        } ?: movieItemBelongsMapper.makeDefaultMovieItemBelongs(),
        budget = budget.orEmpty(),
        genres = genres?.map {
            with(movieItemGenresMapper) {
                it.toPresentation()
            }
        }.orEmpty(),
        homepage = homepage.orEmpty(),
        id = id.orEmpty(),
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orEmpty(),
        posterPath = posterPath.orEmpty(),
        productionCompanies = productionCompanies?.map {
            with(movieItemProdCompMapper) {
                it.toPresentation()
            }
        }.orEmpty(),
        productionCountries = productionCountries?.map {
            with(movieItemProdCountMapper) {
                it.toPresentation()
            }
        }.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue.orEmpty(),
        spokenLanguages = spokenLanguages?.map {
            with(movieItemLangMapper) {
                it.toPresentation()
            }
        }.orEmpty(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video.orEmpty(),
        voteAverage = voteAverage.orEmpty(),
        voteCount = voteCount.orEmpty()
    )
}