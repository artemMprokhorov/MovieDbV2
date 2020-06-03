package com.example.moviedb.catalog.ui.view

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConstantsTest {

    @Test
    fun check_constant_not_null() {
        val constatns = Constants
        assertNotNull(constatns.DEF_STYLE_ATTR)
    }
}