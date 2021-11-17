package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItemProdComp
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemProdCompMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemProdCompMapper = UiMovieItemProdCompMapper()
        assertNotNull(with(uiMovieItemProdCompMapper) {
            domainMovieItemProdComp.toUi()
        })
    }

    companion object {
        val domainMovieItemProdComp = makeDomainMovieItemProdComp()
    }
}