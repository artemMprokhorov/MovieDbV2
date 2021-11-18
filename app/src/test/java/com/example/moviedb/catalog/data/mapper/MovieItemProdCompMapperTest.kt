package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteMovieItemProdComp
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemProdCompMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemProdCompMapper = MovieItemProdCompMapper()
        val remoteMovieItemProdComp = makeRemoteMovieItemProdComp()

        assertNotNull(with(movieItemProdCompMapper) {
            remoteMovieItemProdComp.toDomain()
        })
    }
}