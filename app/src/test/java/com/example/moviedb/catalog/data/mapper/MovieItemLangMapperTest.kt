package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteMovieItemLang
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemLangMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemLangMapper = MovieItemLangMapper()
        assertNotNull(with(movieItemLangMapper) {
            remoteMovieItemLang.toDomain()
        })
    }


    companion object {
        val remoteMovieItemLang = makeRemoteMovieItemLang()
    }
}