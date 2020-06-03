package com.example.moviedb.catalog.data.model

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConstantsTest {

    @Test
    fun check_constants_not_null() {
        val constants = Constants
        assertNotNull(constants.ADULT)
        assertNotNull(constants.BACKDROP_PATH)
        assertNotNull(constants.BELONGS_TO_COLLECTION)
        assertNotNull(constants.BUDGET)
        assertNotNull(constants.GENRES)
        assertNotNull(constants.HOMEPAGE)
        assertNotNull(constants.ID)
        assertNotNull(constants.IMDB_ID)
        assertNotNull(constants.ORIG_LANG)
        assertNotNull(constants.ORIG_TITLE)
        assertNotNull(constants.OVERVIEW)
        assertNotNull(constants.POPULARITY)
        assertNotNull(constants.POSTER_PATH)
        assertNotNull(constants.PROD_COMP)
        assertNotNull(constants.PROD_COUNTRIES)
        assertNotNull(constants.RELEASE_DATE)
        assertNotNull(constants.REVENUE)
        assertNotNull(constants.LANGS)
        assertNotNull(constants.STATUS)
        assertNotNull(constants.TAG)
        assertNotNull(constants.TITLE)
        assertNotNull(constants.VIDEO)
        assertNotNull(constants.VOTE_AVERAGE)
        assertNotNull(constants.VOTE_COUNT)
        assertNotNull(constants.NAME)
        assertNotNull(constants.ISO_639_1)
        assertNotNull(constants.LOGO_PATH)
        assertNotNull(constants.ORIGIN_COUNTRY)
        assertNotNull(constants.ISO_3166_1)
        assertNotNull(constants.PAGE)
        assertNotNull(constants.TOTAL_RESULTS)
        assertNotNull(constants.TOTAL_PAGES)
        assertNotNull(constants.RESULTS)
    }
}

