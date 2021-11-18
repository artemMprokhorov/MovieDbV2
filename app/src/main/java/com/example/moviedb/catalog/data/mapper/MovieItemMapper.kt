package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.domain.model.DomainMovieItem
import javax.inject.Inject

class MovieItemMapper @Inject constructor() {

    fun RemoteMovieItem.toDomain(
        movieItemLangMapper: MovieItemLangMapper,
        movieItemProdCountMapper: MovieItemProdCountMapper,
        movieItemProdCompMapper: MovieItemProdCompMapper,
        movieItemGenresMapper: MovieItemGenresMapper,
        movieItemBelongsMapper: MovieItemBelongsMapper
    ) = DomainMovieItem(
        adult = adult.orEmpty(),
        backdropPath = backdropPath.orEmpty(),
        belongsToCollection =
        with(movieItemBelongsMapper) {
            belongsToCollection?.toDomain()

        } ?: movieItemBelongsMapper.makeEmptyDomainMovieItemBelongs(),
        budget = budget.orEmpty(),
        genres = genres?.map {
            with(movieItemGenresMapper) {
                it.toDomain()
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
                it.toDomain()
            }
        }.orEmpty(),
        productionCountries = productionCountries?.map {
            with(movieItemProdCountMapper) {
                it.fromRemoteToDomain()
            }
        }.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue.orEmpty(),
        spokenLanguages = spokenLanguages?.map {
            with(movieItemLangMapper) {
                it.toDomain()
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