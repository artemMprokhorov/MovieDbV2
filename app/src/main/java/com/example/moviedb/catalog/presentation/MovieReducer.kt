package com.example.moviedb.catalog.presentation

import com.example.moviedb.commons.mvi.MviReducer
import com.example.moviedb.commons.mvi.MviState
import com.example.moviedb.commons.mvi.UnsupportedReduceException
import javax.inject.Inject

class MovieReducer @Inject constructor() : MviReducer<MviState, MovieResult> {

    override fun MviState.reduce(result: MovieResult): MviState {
        return when (val prevState = this) {
            is MovieState.DefaultState -> prevState reduce result
            is MovieState.LoadingState -> prevState reduce result
            is MovieState.ErrorState -> prevState reduce result
            is MovieState.SuccessPopularState -> prevState reduce result
            is MovieState.SuccessItemSelectedState -> prevState reduce result
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun MovieState.DefaultState.reduce(result: MovieResult): MovieState {
        return when (result) {
            is MovieResult.GetPopularResult.InProgress -> MovieState.LoadingState
            is MovieResult.GetItemSelectedResult.InProgress -> MovieState.LoadingState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun MovieState.LoadingState.reduce(result: MovieResult): MovieState {
        return when (result) {
            is MovieResult.GetPopularResult.Success -> MovieState.SuccessPopularState(result.popular)
            is MovieResult.GetItemSelectedResult.Success -> MovieState.SuccessItemSelectedState(
                result.movieItem
            )
            is MovieResult.GetPopularResult.Error -> MovieState.ErrorState(result.error)
            is MovieResult.GetItemSelectedResult.Error -> MovieState.ErrorState(result.error)
            is MovieResult.GetPopularResult.InProgress -> MovieState.LoadingState
            is MovieResult.GetItemSelectedResult.InProgress -> MovieState.LoadingState
        }
    }

    private infix fun MovieState.ErrorState.reduce(result: MovieResult): MovieState {
        throw UnsupportedReduceException(this, result)
    }

    private infix fun MovieState.SuccessPopularState.reduce(result: MovieResult): MovieState {
        return when (result) {
            is MovieResult.GetPopularResult.InProgress -> MovieState.LoadingState
            is MovieResult.GetItemSelectedResult.InProgress -> MovieState.LoadingState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun MovieState.SuccessItemSelectedState.reduce(result: MovieResult): MovieState {
        return when (result) {
            is MovieResult.GetPopularResult.InProgress -> MovieState.LoadingState
            is MovieResult.GetItemSelectedResult.InProgress -> MovieState.LoadingState
            is MovieResult.GetItemSelectedResult.Success -> MovieState.SuccessItemSelectedState(
                result.movieItem
            )
            else -> throw UnsupportedReduceException(this, result)
        }
    }
}