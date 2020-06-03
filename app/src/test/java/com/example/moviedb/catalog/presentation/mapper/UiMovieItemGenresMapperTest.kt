package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItemGenre
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemGenresMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemGenresMapper = UiMovieItemGenresMapper()
        assertNotNull(with(uiMovieItemGenresMapper) {
            domainMovieItemGenre.fromDomainToUi()
        })
    }

    companion object {
        val domainMovieItemGenre = makeDomainMovieItemGenre()

    }
}