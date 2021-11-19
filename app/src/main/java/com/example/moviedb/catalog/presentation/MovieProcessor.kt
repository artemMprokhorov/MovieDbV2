package com.example.moviedb.catalog.presentation

import com.example.moviedb.catalog.data.repo.MovieDataRepository
import com.example.moviedb.catalog.presentation.MovieAction.*
import com.example.moviedb.catalog.presentation.MovieResult.GetItemSelectedResult
import com.example.moviedb.catalog.presentation.MovieResult.GetPopularResult
import com.example.moviedb.catalog.presentation.mapper.*
import com.example.moviedb.commons.threads.CoroutineExecutionThread
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieProcessor @Inject constructor(
    private val repository: MovieDataRepository,
    private val popularMapper: PopularMapper,
    private val popularItemMapper: PopularItemMapper,
    private val movieItemMapper: MovieItemMapper,
    private val movieItemLangMapper: MovieItemLangMapper,
    private val movieItemProdCountMapper: MovieItemProdCountMapper,
    private val movieItemProdCompMapper: MovieItemProdCompMapper,
    private val movieItemGenresMapper: MovieItemGenresMapper,
    private val movieItemBelongsMapper: MovieItemBelongsMapper,
    private val executionThread: CoroutineExecutionThread
) {

    fun actionProcessor(actions: MovieAction): Flow<MovieResult> =
        when (actions) {
            is GetPopularAction -> getPopularProcessor(actions.pageNum)
            is GetItemSelectedAction -> getItemSelectedProcessor(actions.movieId)
        }

    private fun getPopularProcessor(pageNum: String): Flow<GetPopularResult> =
        repository.getPopular(pageNum)
            .map { remotePopular ->
                return@map when (remotePopular != null) {
                    true -> GetPopularResult.Success(with(popularMapper) {
                        remotePopular.toPresentation(popularItemMapper)
                    })
                    else -> GetPopularResult.Error(Throwable())
                }
            }.onStart {
                emit(GetPopularResult.InProgress)
            }.catch { cause: Throwable ->
                emit(GetPopularResult.Error(cause))
            }.flowOn(executionThread.ioThread())


    private fun getItemSelectedProcessor(movieId: String): Flow<GetItemSelectedResult> =
        repository.getMovieItem(movieId)
            .map { movieItem ->
                return@map when (movieItem != null) {
                    true -> GetItemSelectedResult.Success(
                        with(movieItemMapper) {
                            movieItem.toPresentation(
                                movieItemLangMapper,
                                movieItemProdCountMapper,
                                movieItemProdCompMapper,
                                movieItemGenresMapper,
                                movieItemBelongsMapper
                            )
                        }
                    )
                    else -> GetItemSelectedResult.Error(Throwable())
                }
            }.onStart {
                emit(GetItemSelectedResult.InProgress)
            }.catch { cause: Throwable ->
                emit(GetItemSelectedResult.Error(cause))
            }.flowOn(executionThread.ioThread())
}