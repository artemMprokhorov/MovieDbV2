package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiPopularItem
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiPopularItemTest {

    var uiPopularItem = mock<UiPopularItem>()

    @Test
    fun check_get_set() {

        uiPopularItem = makeUiPopularItem()
        uiPopularItem.popularity?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        assertNotNull(uiPopularItem.voteCount)
        assertNotNull(uiPopularItem.video)
        uiPopularItem.posterPath?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.id?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.adult?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.backdropPath?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.originalLanguage?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.originalTitle?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.title?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.voteAverage?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.overview?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
        uiPopularItem.releaseDate?.isNotEmpty()?.let { kotlin.test.assertTrue(it) }
    }


}