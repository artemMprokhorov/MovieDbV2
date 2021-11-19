package com.example.moviedb.commons.mvi

import kotlinx.coroutines.flow.Flow

interface MviUi<TIntent, in TState> {

    fun intents(): Flow<TIntent>

    fun renderStates(uiState: TState)

}