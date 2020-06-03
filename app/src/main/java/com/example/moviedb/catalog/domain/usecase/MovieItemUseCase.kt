package com.example.moviedb.catalog.domain.usecase

import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.domain.repo.MovieRepository
import com.example.moviedb.common.domain.executer.PostExecutionThread
import com.example.moviedb.common.domain.usecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class MovieItemUseCase @Inject constructor(
    private val repository: MovieRepository, postExecutionThread: PostExecutionThread
) : SingleUseCase<DomainMovieItem, String?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: String?): Single<DomainMovieItem> =
        repository.getMovieItem(params)

}