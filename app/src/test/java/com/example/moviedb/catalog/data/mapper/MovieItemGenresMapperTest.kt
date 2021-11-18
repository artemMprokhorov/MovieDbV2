package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteMovieItemGenre
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemGenresMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemGenresMapper = MovieItemGenresMapper()
        val remoteMovieItemGenre = makeRemoteMovieItemGenre()

        assertNotNull(with(movieItemGenresMapper) {
            remoteMovieItemGenre.toDomain()
        })
    }
}