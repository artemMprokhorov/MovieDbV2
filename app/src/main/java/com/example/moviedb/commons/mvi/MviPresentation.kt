package com.example.moviedb.commons.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MviPresentation<TIntent, TState> {

    fun processIntents(intents: Flow<TIntent>)

    fun uiStates(): StateFlow<TState>
}