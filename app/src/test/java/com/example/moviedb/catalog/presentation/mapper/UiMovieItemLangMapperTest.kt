package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItemLang
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemLangMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemLangMapper = UiMovieItemLangMapper()
        assertNotNull(with(uiMovieItemLangMapper) {
            domainMovieItemLang.fromDomainToUi()
        })
    }

    companion object {
        val domainMovieItemLang = makeDomainMovieItemLang()
    }
}