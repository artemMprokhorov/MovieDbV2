package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItem
import com.example.moviedb.catalog.domain.model.DomainMovieItem
import javax.inject.Inject

class MovieItemMapper @Inject constructor() {

    fun RemoteMovieItem.fromRemoteToDomain(
        movieItemLangMapper: MovieItemLangMapper,
        movieItemProdCountMapper: MovieItemProdCountMapper,
        movieItemProdCompMapper: MovieItemProdCompMapper,
        movieItemGenresMapper: MovieItemGenresMapper,
        movieItemBelongsMapper: MovieItemBelongsMapper
    ): DomainMovieItem = DomainMovieItem(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection =
        with(movieItemBelongsMapper) {
            belongs_to_collection?.fromRemoteToDomain()

        },
        budget = budget,
        genres = genres?.map {
            with(movieItemGenresMapper) {
                it.fromRemoteToDomain()
            }
        },
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies?.map {
            with(movieItemProdCompMapper) {
                it.fromRemoteToDomain()
            }
        },
        production_countries = production_countries?.map {
            with(movieItemProdCountMapper) {
                it.fromRemoteToDomain()
            }
        },
        release_date = release_date,
        revenue = revenue,
        spoken_languages = spoken_languages?.map {
            with(movieItemLangMapper) {
                it.fromRemoteToDomain()
            }
        },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count

    )
}