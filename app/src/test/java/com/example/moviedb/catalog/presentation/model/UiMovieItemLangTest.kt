package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItemLang
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class UiMovieItemLangTest {

    var uiMovieItemLang = mock<UiMovieItemLang>()

    @Test
    fun check_get_set() {
        uiMovieItemLang = makeUiMovieItemLang()
        uiMovieItemLang.iso?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemLang.name?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
    }

}