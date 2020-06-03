package com.example.moviedb.catalog.data.factory

import com.example.moviedb.RandomFactory
import com.example.moviedb.catalog.data.model.*

object DataItemsFactory {

    fun makeRemotePopular() = RemotePopular(
        RandomFactory.generateLong(),
        RandomFactory.generateLong(),
        RandomFactory.generateLong(),
        emptyList()
    )

    fun makeRemoteMovieItemBelongs() = RemoteMovieItemBelongs(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeRemoteMovieItemGenre() = RemoteMovieItemGenre(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeRemotePopularItem() = RemotePopularItem(
        RandomFactory.generateString(),
        RandomFactory.generateLong(),
        RandomFactory.generateBoolean(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeRemoteMovieItemLang() = RemoteMovieItemLang(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeRemoteMovieItemProdComp() = RemoteMovieItemProdComp(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )


    fun makeRemoteItemProdCount() = RemoteMovieItemProdCount(
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeRemoteMovieItem() = RemoteMovieItem(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RemoteMovieItemBelongs(
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