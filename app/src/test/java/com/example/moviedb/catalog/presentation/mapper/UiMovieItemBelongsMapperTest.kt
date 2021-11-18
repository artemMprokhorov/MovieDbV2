package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemBelongsMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemBelongsMapper = UiMovieItemBelongsMapper()
        val domainMovieItemBelongs = PresenterItemsFactory.makeDomainMovieItemBelongs()

        assertNotNull(with(uiMovieItemBelongsMapper) {
            domainMovieItemBelongs.toUi()
        })
    }
}