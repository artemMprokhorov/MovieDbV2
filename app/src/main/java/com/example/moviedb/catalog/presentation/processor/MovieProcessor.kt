package com.example.moviedb.catalog.presentation.processor

import com.example.moviedb.catalog.domain.usecase.MovieItemUseCase
import com.example.moviedb.catalog.domain.usecase.PopularUseCase
import com.example.moviedb.catalog.presentation.action.MovieAction
import com.example.moviedb.catalog.presentation.action.MovieAction.Movie
import com.example.moviedb.catalog.presentation.action.MovieAction.MovieLoading
import com.example.moviedb.catalog.presentation.result.MovieResult
import com.example.moviedb.catalog.presentation.result.MovieResult.GetMovieLoadingResult
import com.example.moviedb.catalog.presentation.result.MovieResult.GetMovieResult
import com.example.moviedb.common.presentation.execution.ExecutionThread
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class MovieProcessor @Inject constructor(
    private val popularUseCase: PopularUseCase,
    private val movieItemUseCase: MovieItemUseCase,
    private val executionThread: ExecutionThread
) {
    var actionProcessor: ObservableTransformer<MovieAction, MovieResult>
        private set

    init {
        actionProcessor = ObservableTransformer { observableAction ->
            observableAction.publish { action ->
                Observable.merge(
                    action.ofType(Movie::class.java)
                        .compose(inboxStateProcessor),
                    action.ofType(MovieLoading::class.java)
                        .compose(loadingInboxProcessor)
                )
            }
        }
    }

    private val inboxStateProcessor =
        ObservableTransformer<Movie, GetMovieResult> { actions ->
            actions.switchMap { it ->
                popularUseCase
                    .buildUseCaseObservable(it.pageNum)
                    .toObservable()
                    .map { GetMovieResult.Success(it) }
                    .cast(GetMovieResult::class.java)
                    .onErrorReturn(GetMovieResult::Error)
                    .startWith(GetMovieResult.InProgress)
                    .subscribeOn(executionThread.schedulerForSubscribing())
                    .observeOn(executionThread.schedulerForObserving())
            }
        }

    private val loadingInboxProcessor =
        ObservableTransformer<MovieLoading, GetMovieLoadingResult> { actions ->
            actions.switchMap { it ->
                movieItemUseCase
                    .buildUseCaseObservable(it.movieId)
                    .toObservable()
                    .map { GetMovieLoadingResult.Success(it) }
                    .cast(GetMovieLoadingResult::class.java)
                    .onErrorReturn(GetMovieLoadingResult::Error)
                    .startWith(GetMovieLoadingResult.InProgress)
                    .subscribeOn(executionThread.schedulerForSubscribing())
                    .observeOn(executionThread.schedulerForObserving())
            }
        }
}