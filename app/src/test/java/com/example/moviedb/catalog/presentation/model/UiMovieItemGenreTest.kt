package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItemGenre
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class UiMovieItemGenreTest {

    var uiMovieItemGenre = mock<UiMovieItemGenre>()

    @Test
    fun check_get_set() {
        uiMovieItemGenre = makeUiMovieItemGenre()

        uiMovieItemGenre.id.isNotEmpty().let { kotlin.test.assertTrue(it) }
        uiMovieItemGenre.name.isNotEmpty().let { kotlin.test.assertTrue(it) }
    }
}