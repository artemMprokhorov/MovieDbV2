package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiPopular
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiPopularTest {

    var uiPopular = mock<UiPopular>()

    @Test
    fun check_get_set() {

        uiPopular = makeUiPopular()

        assertNotNull(uiPopular.page)
        assertNotNull(uiPopular.totalResults)
        assertNotNull(uiPopular.totalPages)
        assertNotNull(uiPopular.results)
    }
}