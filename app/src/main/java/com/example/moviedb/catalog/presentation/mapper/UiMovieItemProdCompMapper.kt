package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.domain.model.DomainMovieItemProdComp
import com.example.moviedb.catalog.presentation.model.UiMovieItemProdComp
import javax.inject.Inject

class UiMovieItemProdCompMapper @Inject constructor() {

    fun DomainMovieItemProdComp.fromDomainToUi(): UiMovieItemProdComp = UiMovieItemProdComp(
        id = id,
        logo_path = logo_path,
        name = name,
        origin_country = origin_country

    )
}