package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItemBelongs
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class UiMovieItemBelongsTest {

    var uiMovieItemBelongs = mock<UiMovieItemBelongs>()

    @Test
    fun check_get_set() {

        uiMovieItemBelongs = makeUiMovieItemBelongs()
        uiMovieItemBelongs.id?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemBelongs.name?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemBelongs.poster_path?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiMovieItemBelongs.backdrop_path?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }

    }
}