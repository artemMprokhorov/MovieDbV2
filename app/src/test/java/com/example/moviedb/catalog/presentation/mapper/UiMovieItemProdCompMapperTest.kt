package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItemProdComp
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemProdCompMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemProdCompMapper = UiMovieItemProdCompMapper()
        val domainMovieItemProdComp = makeDomainMovieItemProdComp()

        assertNotNull(with(uiMovieItemProdCompMapper) {
            domainMovieItemProdComp.toUi()
        })
    }
}