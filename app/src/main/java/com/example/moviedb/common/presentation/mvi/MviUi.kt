package com.example.moviedb.common.presentation.mvi

import io.reactivex.Observable

interface MviUi<TIntent, in TUiState> {

    fun userIntents(): Observable<TIntent>

    fun renderUiStates(uiState: TUiState)

}