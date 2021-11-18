package com.example.moviedb.catalog.presentation.factory

import com.example.moviedb.RandomFactory
import com.example.moviedb.catalog.domain.model.*

object PresenterItemsFactory {

    fun makeDomainMovieItemBelongs() = DomainMovieItemBelongs(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeDomainMovieItemGenre() = DomainMovieItemGenre(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeDomainMovieItemLang() = DomainMovieItemLang(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeDomainMovieItemProdComp() = DomainMovieItemProdComp(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )


    fun makeMovieItemProdCount() = DomainMovieItemProdCount(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeDomainMovieItem() = DomainMovieItem(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        DomainMovieItemBelongs(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString()
        ),
        RandomFactory.generateString(),
        emptyList(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        emptyList(),
        emptyList(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        emptyList(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )
}