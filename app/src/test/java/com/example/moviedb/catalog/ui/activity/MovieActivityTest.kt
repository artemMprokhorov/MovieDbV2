package com.example.moviedb.catalog.ui.activity

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviedb.catalog.presentation.state.MovieState
import com.example.moviedb.catalog.ui.adapter.MovieAdapter
import com.example.moviedb.catalog.ui.factory.UiItemsFactory
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import kotlin.test.assertFalse
import kotlin.test.assertNotSame

@RunWith(AndroidJUnit4::class)
class MovieActivityTest {

    private lateinit var activityScenario: ActivityScenario<MovieActivity>
    private val movieAdapter = mock<MovieAdapter>()
    private val throwable = mock<Throwable>()

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        activityScenario = ActivityScenario.launch(MovieActivity::class.java)
    }

    @Test
    fun when_activity_launched_then_check_injected_objects_not_null() {
        activityScenario.onActivity {
            assertNotNull(it.movieAdapter)
            assertNotNull(it.movieItemDialogFragment)
            assertNotNull(it.viewModelFactory)
            assertNotNull(it.binding)
            assertNotNull(it.viewModel.uiStates())
        }
    }

    @Test
    fun when_renderUiStates_called_with_success_loading_then_check_page_num() {
        activityScenario.onActivity {
            it.renderUiStates(MovieState.SuccessState(uiPopular))
            assertTrue(it.currentPageNum > 0)
        }
    }

    @Test
    fun when_onItemLoaded_then_dialogFragment_visible() {
        activityScenario.onActivity {
            it.onItemLoaded(uiMovieItem)
            assertTrue(it.movieItemDialogFragment.isVisible)

        }
    }

    @Test
    fun when_onDismiss_fragment_dialog_called_then_dialog_hided() {
        activityScenario.onActivity {
            it.movieItemDialogFragment.show(it.supportFragmentManager)
            it.movieItemDialogFragment.onDismiss()
            assertFalse(it.movieItemDialogFragment.isVisible)

        }
    }

    @Test
    fun when_onItemClicked_without_null_then_content_layout_visible() {
        activityScenario.onActivity {
            it.onItemClicked(uiPopularItem)
            assertTrue(it.binding.contentLayout.visibility == View.VISIBLE)
        }
    }

    @Test
    fun when_setErrorDismissListener_called_then_clickListener_not_null_in_binding() {
        activityScenario.onActivity {
            it.setErrorDismissListener()
            assertNotNull(it.binding.itemClickListener)
        }
    }

    @Test
    fun when_setScreenForError_called_then_check_logic_variants() {
        activityScenario.onActivity {
            it.setScreenForError(true)
            assertTrue(it.binding.error.visibility == View.VISIBLE)
            whenever(movieAdapter.itemCount).thenReturn(1)
            it.setScreenForError(false)
            assertTrue(it.binding.contentLayout.visibility == View.VISIBLE)
        }
    }

    @Test
    fun when_setScreenForContent_called_with_false_then_layout_gone() {
        activityScenario.onActivity {
            it.setScreenForContent(false)
            assertTrue(it.binding.contentLayout.visibility == View.GONE)
        }
    }

    @Test
    fun when_setDefaultState_loading_layout_visible() {
        activityScenario.onActivity {
            it.setDefaultState()
            assertTrue(it.binding.loading.visibility == View.VISIBLE)
            assertTrue(it.binding.contentLayout.visibility == View.GONE)
        }
    }

    @Test
    fun when_setIncomingData_with_null_then_error_layout_visible() {
        activityScenario.onActivity {
            it.setIncomingData(null)
            assertTrue(it.binding.error.visibility == View.VISIBLE)
        }
    }

    @Test
    fun when_renderUiStates_with_error_then_error_layout_visible() {
        activityScenario.onActivity {
            it.renderUiStates(MovieState.Error(throwable))
            assertTrue(it.binding.error.visibility == View.VISIBLE)
        }
    }

    @Test
    fun when_renderUiStates_with_content_then_content_layout_visible() {
        activityScenario.onActivity {
            it.renderUiStates(MovieState.SuccessMovieLoading(uiMovieItem))
            assertTrue(it.binding.contentLayout.visibility == View.VISIBLE)
        }
    }

    @Test
    fun constants_not_null_or_empty() {
        val constants = Constants
        assertNotNull(constants.PAGE_INIT_VALUE)
        assertNotNull(constants.INI_PAGE)
        assertNotNull(constants.DIRECTION)
        assertNotNull(constants.LOADING_MORE)

        assertNotSame(constants.LOADING_MORE, EMPTY_STRING)
    }

    companion object {
        private val factory = UiItemsFactory
        val uiMovieItem = factory.makeUiMovieItem()
        val uiPopularItem = factory.makeUiPopularItem()
        val uiPopular = factory.makeUiPopular()
        const val EMPTY_STRING = ""
    }

}