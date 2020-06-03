package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.model.RemoteMovieItemLang
import com.example.moviedb.catalog.domain.model.DomainMovieItemLang
import javax.inject.Inject

class MovieItemLangMapper @Inject constructor() {

    fun RemoteMovieItemLang.fromRemoteToDomain(): DomainMovieItemLang = DomainMovieItemLang(
        iso = iso,
        name = name
    )
}