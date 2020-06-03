package com.example.moviedb.common.presentation.mvi

import io.reactivex.Observable

interface MviViewModel<TIntent, TUiState> {

    fun processUserIntents(userIntents: Observable<TIntent>)

    fun uiStates(): Observable<TUiState>

}