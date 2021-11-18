package com.example.moviedb.catalog.ui.factory

import com.example.moviedb.RandomFactory
import com.example.moviedb.catalog.presentation.model.*

object UiItemsFactory {

    private val randomFactory = RandomFactory

    fun makeUiMovieItem() = UiMovieItem(
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        makeUiMovieItemBelongs(),
        randomFactory.generateString(),
        emptyList(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        emptyList(),
        emptyList(),
        randomFactory.generateString(),
        emptyList(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiMovieItemBelongs() = UiMovieItemBelongs(
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiMovieItemGenre() = UiMovieItemGenre(
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiMovieItemLang() = UiMovieItemLang(
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiMovieItemProdCount() = UiMovieItemProdCount(
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiMovieItemProdComp() = UiMovieItemProdComp(
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiPopularItem() = UiPopularItem(
        randomFactory.generateString(),
        randomFactory.generateString(),
        true,
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString(),
        randomFactory.generateString()
    )

    fun makeUiPopular() = UiPopular(
        1,
        randomFactory.generateLong(),
        randomFactory.generateLong(),
        emptyList()
    )

}