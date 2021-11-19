package com.example.moviedb.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.catalog.presentation.MovieAction.GetItemSelectedAction
import com.example.moviedb.catalog.presentation.MovieAction.GetPopularAction
import com.example.moviedb.catalog.presentation.MovieState.DefaultState
import com.example.moviedb.commons.mvi.MviPresentation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
class MovieViewModel @Inject constructor(
    private val movieProcessor: MovieProcessor,
    private val reducer: MovieReducer,
) : ViewModel(), MviPresentation<MovieIntent, MovieState> {

    private val defaultState: MovieState = DefaultState
    private val uiState = MutableStateFlow(defaultState)

    override fun processIntents(intents: Flow<MovieIntent>) {
        intents
            .buffer()
            .flatMapMerge { userIntent ->
                movieProcessor.actionProcessor(userIntent.toAction())
            }
            .scan(defaultState) { previousState, result ->
                with(reducer) { previousState reduce result } as MovieState
            }
            .onEach { uiState ->
                this.uiState.value = uiState
            }
            .launchIn(viewModelScope)
    }

    override fun uiStates(): StateFlow<MovieState> = uiState

    private fun MovieIntent.toAction(): MovieAction {
        return when (this) {
            is MovieIntent.GetPopularIntent -> GetPopularAction(pageNum)
            is MovieIntent.GetItemSelectedIntent -> GetItemSelectedAction(movieId)
        }
    }
}