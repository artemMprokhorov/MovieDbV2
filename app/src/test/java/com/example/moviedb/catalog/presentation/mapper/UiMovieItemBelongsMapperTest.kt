package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemBelongsMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemBelongsMapper = UiMovieItemBelongsMapper()
        assertNotNull(with(uiMovieItemBelongsMapper) {
            domainMovieItemBelongs.toUi()
        })
    }

    companion object {
        val domainMovieItemBelongs = PresenterItemsFactory.makeDomainMovieItemBelongs()
    }
}