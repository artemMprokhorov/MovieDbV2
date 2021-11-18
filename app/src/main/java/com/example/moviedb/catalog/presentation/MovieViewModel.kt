package com.example.moviedb.catalog.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.catalog.presentation.MovieAction.Movie
import com.example.moviedb.catalog.presentation.MovieAction.MovieLoading
import com.example.moviedb.catalog.presentation.MovieUserIntent.InitialUserIntent
import com.example.moviedb.catalog.presentation.MovieUserIntent.MovieLoadingUserIntent
import com.example.moviedb.catalog.presentation.mapper.*
import com.example.moviedb.commons.mvi.MviViewModel
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
        .scan(MovieState.DefaultState, reducer)


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

                        MovieResult.GetMovieResult.InProgress -> MovieState.LoadingState

                        is MovieResult.GetMovieResult.Success -> MovieState.SuccessPopularState(

                            with(uiMovieStateMapper) {
                                result.state.toUi(uiStateItemMapper)
                            })

                        is MovieResult.GetMovieResult.Error -> MovieState.ErrorState(result.error)
                    }

                is MovieResult.GetMovieLoadingResult ->
                    when (result) {

                        MovieResult.GetMovieLoadingResult.InProgress -> MovieState.LoadingState

                        is MovieResult.GetMovieLoadingResult.Success -> MovieState.SuccessItemSelectedState(
                            with(uiMovieItemMapper) {
                                result.domainMovieItem.toUi(
                                    uiMovieItemLangMapper, uiMovieItemProdCountMapper,
                                    uiMovieItemProdCompMapper, uiMovieItemGenresMapper,
                                    uiMovieItemBelongsMapper
                                )
                            }
                        )

                        is MovieResult.GetMovieLoadingResult.Error -> MovieState.ErrorState(result.error)
                    }
            }
        }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}