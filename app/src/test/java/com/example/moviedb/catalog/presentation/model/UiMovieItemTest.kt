package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItem
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.test.assertTrue

class UiMovieItemTest {

    var uiMovieItem = mock<UiMovieItem>()

    @Test
    fun check_get_set() {

        uiMovieItem = makeUiMovieItem()
        uiMovieItem.title?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.popularity?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.vote_count?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.vote_average?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.adult?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.original_title?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.original_language?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.overview?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.release_date?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.backdrop_path?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.budget?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.homepage?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.id?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.imdb_id?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.poster_path?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.revenue?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.status?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.tagline?.isNotEmpty()?.let { assertTrue(it) }
        uiMovieItem.video?.isNotEmpty()?.let { assertTrue(it) }
        assertNotNull(uiMovieItem.belongs_to_collection?.copy())
        assertNotNull(uiMovieItem.production_companies?.size)
        assertNotNull(uiMovieItem.production_countries?.size)
        assertNotNull(uiMovieItem.spoken_languages?.size)
        assertNotNull(uiMovieItem.genres?.size)
    }
}