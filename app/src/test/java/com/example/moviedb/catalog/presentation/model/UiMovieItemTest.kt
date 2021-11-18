package com.example.moviedb.catalog.presentation.model

import com.example.moviedb.catalog.ui.factory.UiItemsFactory.makeUiMovieItem
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.test.assertTrue

class UiMovieItemTest {

    var uiMovieItem = mock<UiMovieItem>()

    @Test
    fun check_get_set() {

        uiMovieItem = makeUiMovieItem()

        uiMovieItem.title.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.popularity.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.voteCount.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.voteAverage.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.adult.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.originalTitle.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.originalLanguage.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.overview.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.releaseDate.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.backdropPath.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.budget.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.homepage.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.id.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.imdbId.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.posterPath.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.revenue.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.status.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.tagline.isNotEmpty().let { assertTrue(it) }
        uiMovieItem.video.isNotEmpty().let { assertTrue(it) }
        assertNotNull(uiMovieItem.belongsToCollection.copy())
        assertNotNull(uiMovieItem.productionCompanies.size)
        assertNotNull(uiMovieItem.productionCountries.size)
        assertNotNull(uiMovieItem.spokenLanguages.size)
        assertNotNull(uiMovieItem.genres.size)
    }
}