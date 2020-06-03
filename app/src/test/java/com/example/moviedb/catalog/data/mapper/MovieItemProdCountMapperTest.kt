package com.example.moviedb.catalog.data.mapper

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemoteItemProdCount
import org.junit.Assert.assertNotNull
import org.junit.Test

class MovieItemProdCountMapperTest {

    @Test
    fun fromRemoteToDomain() {
        val movieItemProdCountMapper = MovieItemProdCountMapper()
        assertNotNull(with(movieItemProdCountMapper) {
            remoteItemProdCount.fromRemoteToDomain()
        })
    }

    companion object {
        val remoteItemProdCount = makeRemoteItemProdCount()
    }
}