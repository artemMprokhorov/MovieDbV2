package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemBelongs
import com.example.moviedb.catalog.domain.model.DomainMovieItemBelongs
import javax.inject.Inject

class MovieItemBelongsMapper @Inject constructor() {

    fun RemoteMovieItemBelongs.toDomain() = DomainMovieItemBelongs(
        id = id.orEmpty(),
        name = name.orEmpty(),
        backdropPath = backdropPath.orEmpty(),
        posterPath = posterPath.orEmpty()
    )

    fun makeEmptyDomainMovieItemBelongs() = DomainMovieItemBelongs(
        id = "",
        name = "",
        backdropPath = "",
        posterPath = ""
    )
}