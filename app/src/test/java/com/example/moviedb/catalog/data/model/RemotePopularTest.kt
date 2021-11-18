package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemotePopular
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test

class RemotePopularTest {

    var remotePopular = mock<RemotePopular>()

    @Test
    fun check_get_set() {

        remotePopular = makeRemotePopular()
        assertNotNull(remotePopular.copy())
    }
}