package com.example.moviedb.common.presentation.execution

import org.junit.Assert.assertNotNull
import org.junit.Test

class UiThreadTest {

    @Test
    fun getScheduler() {
        assertNotNull(UiThread().scheduler)
    }
}