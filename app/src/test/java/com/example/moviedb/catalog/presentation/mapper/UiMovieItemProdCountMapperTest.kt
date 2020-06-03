package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeMovieItemProdCount
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemProdCountMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemProdCountMapper = UiMovieItemProdCountMapper()
        assertNotNull(with(uiMovieItemProdCountMapper) {
            domainMovieItemProdCount.fromDomainToUi()
        })
    }

    companion object {
        val domainMovieItemProdCount = makeMovieItemProdCount()
    }
}