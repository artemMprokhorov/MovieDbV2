package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemBelongs
import com.example.moviedb.catalog.domain.model.DomainMovieItemBelongs
import javax.inject.Inject

class MovieItemBelongsMapper @Inject constructor() {

    fun RemoteMovieItemBelongs.fromRemoteToDomain(): DomainMovieItemBelongs =
        DomainMovieItemBelongs(
            id = id,
            name = name,
            backdrop_path = backdrop_path,
            poster_path = poster_path
        )
}