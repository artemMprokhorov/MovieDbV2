package com.example.moviedb.catalog.ui.util

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConstantsTest {

    @Test
    fun check_constants_not_null() {
        val constants = Constants
        assertNotNull(constants.PRIMARY_OVERRIDED_WIDTH)
        assertNotNull(constants.PRIMARY_OVERRIDED_HEIGHT)
        assertNotNull(constants.POSTER_OVERRIDED_WIDTH)
        assertNotNull(constants.POSTER_OVERRIDED_HEIGHT)
        assertNotNull(constants.ROUNDING_RADIUS)
        assertNotNull(constants.DURATION)
        assertNotNull(constants.PATH)
        assertNotNull(constants.VALUES)
        assertNotNull(constants.PROPERTY_NAME)
    }
}