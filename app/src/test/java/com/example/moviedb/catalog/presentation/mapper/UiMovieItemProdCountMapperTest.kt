package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeMovieItemProdCount
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemProdCountMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemProdCountMapper = UiMovieItemProdCountMapper()
        val domainMovieItemProdCount = makeMovieItemProdCount()

        assertNotNull(with(uiMovieItemProdCountMapper) {
            domainMovieItemProdCount.toUi()
        })
    }
}