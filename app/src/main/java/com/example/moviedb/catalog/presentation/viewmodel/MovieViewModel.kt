package com.example.moviedb.catalog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.catalog.presentation.action.MovieAction
import com.example.moviedb.catalog.presentation.action.MovieAction.Movie
import com.example.moviedb.catalog.presentation.action.MovieAction.MovieLoading
import com.example.moviedb.catalog.presentation.intent.MovieUserIntent
import com.example.moviedb.catalog.presentation.intent.MovieUserIntent.InitialUserIntent
import com.example.moviedb.catalog.presentation.intent.MovieUserIntent.MovieLoadingUserIntent
import com.example.moviedb.catalog.presentation.mapper.*
import com.example.moviedb.catalog.presentation.processor.MovieProcessor
import com.example.moviedb.catalog.presentation.result.MovieResult
import com.example.moviedb.catalog.presentation.state.MovieState
import com.example.moviedb.common.presentation.mvi.MviViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


class MovieViewModel @Inject constructor(
    private val movieProcessor: MovieProcessor,
    private val uiMovieStateMapper: UiMovieStateMapper,
    private val uiStateItemMapper: UiStateItemMapper,
    private val uiMovieItemMapper: UiMovieItemMapper,

    private val uiMovieItemLangMapper: UiMovieItemLangMapper,
    private val uiMovieItemProdCountMapper: UiMovieItemProdCountMapper,
    private val uiMovieItemProdCompMapper: UiMovieItemProdCompMapper,
    private val uiMovieItemGenresMapper: UiMovieItemGenresMapper,
    private val uiMovieItemBelongsMapper: UiMovieItemBelongsMapper
) : ViewModel(), MviViewModel<MovieUserIntent, MovieState> {


    private val userIntentSubject: PublishSubject<MovieUserIntent> = PublishSubject.create()
    private val statesObservable: Observable<MovieState> = compose()
    private val liveDataUiState = MutableLiveData<MovieState>()
    private val disposable = CompositeDisposable()

    init {
        disposable += statesObservable.subscribe(liveDataUiState::setValue) { }
    }

    override fun processUserIntents(userIntents: Observable<MovieUserIntent>) {
        userIntents.subscribe(userIntentSubject)
    }

    override fun uiStates(): Observable<MovieState> = statesObservable


    fun liveData(): LiveData<MovieState> = liveDataUiState

    private fun compose(): Observable<MovieState> = userIntentSubject
        .map { userIntent -> transformUserIntentsIntoActions(userIntent) }
        .compose(movieProcessor.actionProcessor)
        .scan(MovieState.Default, reducer)


    private fun transformUserIntentsIntoActions(userIntent: MovieUserIntent): MovieAction =
        when (userIntent) {
            is InitialUserIntent -> Movie(userIntent.pageNum)
            is MovieLoadingUserIntent -> MovieLoading(userIntent.movieId)
        }

    private val reducer: BiFunction<MovieState, MovieResult, MovieState>
        get() = BiFunction { _: MovieState, result: MovieResult ->
            when (result) {
                is MovieResult.GetMovieResult ->
                    when (result) {

                        MovieResult.GetMovieResult.InProgress -> MovieState.Loading

                        is MovieResult.GetMovieResult.Success -> MovieState.SuccessState(

                            with(uiMovieStateMapper) {
                                result.state.toUi(uiStateItemMapper)
                            })

                        is MovieResult.GetMovieResult.Error -> MovieState.Error(result.error)
                    }

                is MovieResult.GetMovieLoadingResult ->
                    when (result) {

                        MovieResult.GetMovieLoadingResult.InProgress -> MovieState.Loading

                        is MovieResult.GetMovieLoadingResult.Success -> MovieState.SuccessMovieLoading(
                            with(uiMovieItemMapper) {
                                result.domainMovieItem.toUi(
                                    uiMovieItemLangMapper, uiMovieItemProdCountMapper,
                                    uiMovieItemProdCompMapper, uiMovieItemGenresMapper,
                                    uiMovieItemBelongsMapper
                                )
                            }
                        )

                        is MovieResult.GetMovieLoadingResult.Error -> MovieState.Error(result.error)
                    }
            }
        }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}