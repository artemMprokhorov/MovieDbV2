package com.example.moviedb.catalog.domain.usecase

import com.example.moviedb.catalog.domain.model.DomainPopular
import com.example.moviedb.catalog.domain.repo.MovieRepository
import com.example.moviedb.common.domain.executer.PostExecutionThread
import com.example.moviedb.common.domain.usecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    private val repository: MovieRepository, postExecutionThread: PostExecutionThread
) : SingleUseCase<DomainPopular, String?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: String?): Single<DomainPopular> =
        repository.getPopular(params)


}