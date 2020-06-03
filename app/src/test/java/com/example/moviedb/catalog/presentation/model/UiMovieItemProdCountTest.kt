package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItemProdCount
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class UiMovieItemProdCountTest {

    var uiMovieItemProdCount = mock<UiMovieItemProdCount>()

    @Test
    fun check_get_set() {

        uiMovieItemProdCount = makeUiMovieItemProdCount()
        uiMovieItemProdCount.iso?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemProdCount.name?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
    }

}