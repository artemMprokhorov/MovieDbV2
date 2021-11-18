package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteMovieItem
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemMapper = MovieItemMapper()
        val movieItemLangMapper = MovieItemLangMapper()
        val movieItemProdCountMapper = MovieItemProdCountMapper()
        val movieItemProdCompMapper = MovieItemProdCompMapper()
        val movieItemGenresMapper = MovieItemGenresMapper()
        val movieItemBelongsMapper = MovieItemBelongsMapper()
        val remoteMovieItem = makeRemoteMovieItem()

        assertNotNull(with(movieItemMapper) {
            remoteMovieItem.toDomain(
                movieItemLangMapper,
                movieItemProdCountMapper,
                movieItemProdCompMapper,
                movieItemGenresMapper,
                movieItemBelongsMapper
            )
        })
    }
}