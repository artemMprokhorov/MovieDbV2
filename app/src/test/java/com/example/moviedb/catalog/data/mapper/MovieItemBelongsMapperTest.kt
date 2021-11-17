package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteMovieItemBelongs
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemBelongsMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemBelongsMapper = MovieItemBelongsMapper()
        assertNotNull(with(movieItemBelongsMapper) {
            remoteMovieItemBelongs.toDomain()
        })
    }

    companion object {
        val remoteMovieItemBelongs = makeRemoteMovieItemBelongs()
    }
}