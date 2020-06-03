package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItemProdComp
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class UiMovieItemProdCompTest {

    var uiMovieItemProdComp = mock<UiMovieItemProdComp>()

    @Test
    fun check_get_set() {

        uiMovieItemProdComp = makeUiMovieItemProdComp()
        uiMovieItemProdComp.id?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemProdComp.logo_path?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemProdComp.name?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemProdComp.origin_country?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }

    }
}