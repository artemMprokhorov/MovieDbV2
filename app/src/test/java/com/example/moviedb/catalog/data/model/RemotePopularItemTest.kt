package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.factory.DataItemsFactory.makeRemotePopularItem
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test

class RemotePopularItemTest {

    var remotePopularItem = mock<RemotePopularItem>()

    @Test
    fun check_get_set() {

        remotePopularItem = makeRemotePopularItem()
        assertNotNull(remotePopularItem.copy())

    }
}