package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.presentation.model.UiMovieItem
import javax.inject.Inject

class UiMovieItemMapper @Inject constructor() {

    fun DomainMovieItem.fromDomainToUi(
        uiMovieItemLangMapper: UiMovieItemLangMapper,
        uiMovieItemProdCountMapper: UiMovieItemProdCountMapper,
        uiMovieItemProdCompMapper: UiMovieItemProdCompMapper,
        uiMovieItemGenresMapper: UiMovieItemGenresMapper,
        uiMovieItemBelongsMapper: UiMovieItemBelongsMapper
    ): UiMovieItem = UiMovieItem(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection =
        with(uiMovieItemBelongsMapper) {
            belongs_to_collection?.fromDomainToUi()

        },
        budget = budget,
        genres = genres?.map {
            with(uiMovieItemGenresMapper) {
                it.fromDomainToUi()
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
            with(uiMovieItemProdCompMapper) {
                it.fromDomainToUi()
            }
        },
        production_countries = production_countries?.map {
            with(uiMovieItemProdCountMapper) {
                it.fromDomainToUi()
            }
        },
        release_date = release_date,
        revenue = revenue,
        spoken_languages = spoken_languages?.map {
            with(uiMovieItemLangMapper) {
                it.fromDomainToUi()
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