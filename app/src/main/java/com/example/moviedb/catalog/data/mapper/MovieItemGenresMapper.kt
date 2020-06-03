package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemGenre
import com.example.moviedb.catalog.domain.model.DomainMovieItemGenre
import javax.inject.Inject

class MovieItemGenresMapper @Inject constructor() {

    fun RemoteMovieItemGenre.fromRemoteToDomain(): DomainMovieItemGenre = DomainMovieItemGenre(
        id = id,
        name = name
    )
}