package com.example.moviedb.catalog.presentation.mapper

import com.example.moviedb.catalog.presentation.factory.PresenterItemsFactory.makeDomainMovieItem
import org.junit.Assert.assertNotNull
import org.junit.Test

class UiMovieItemMapperTest {

    @Test
    fun fromDomainToUi() {
        val uiMovieItemMapper = UiMovieItemMapper()
        val uiMovieItemLangMapper = UiMovieItemLangMapper()
        val uiMovieItemProdCountMapper = UiMovieItemProdCountMapper()
        val uiMovieItemProdCompMapper = UiMovieItemProdCompMapper()
        val uiMovieItemGenresMapper = UiMovieItemGenresMapper()
        val uiMovieItemBelongsMapper = UiMovieItemBelongsMapper()
        assertNotNull(with(uiMovieItemMapper) {
            domainMovieItem.toUi(
                uiMovieItemLangMapper,
                uiMovieItemProdCountMapper,
                uiMovieItemProdCompMapper,
                uiMovieItemGenresMapper,
                uiMovieItemBelongsMapper
            )
        })
    }

    companion object {
        val domainMovieItem = makeDomainMovieItem()
    }
}