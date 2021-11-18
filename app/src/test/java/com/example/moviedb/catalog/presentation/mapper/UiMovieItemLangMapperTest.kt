package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItemLang
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemLangMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemLangMapper = UiMovieItemLangMapper()
        val domainMovieItemLang = makeDomainMovieItemLang()

        assertNotNull(with(uiMovieItemLangMapper) {
            domainMovieItemLang.toUi()
        })
    }
}