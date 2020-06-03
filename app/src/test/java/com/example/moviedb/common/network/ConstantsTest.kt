package com.example.moviedb.common.network

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConstantsTest {

    @Test
    fun check_constants_not_null() {
        val constants = Constants
        assertNotNull(constants.TIME_OUT)
    }

}