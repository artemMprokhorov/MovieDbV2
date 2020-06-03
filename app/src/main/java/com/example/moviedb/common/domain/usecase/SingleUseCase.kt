package com.example.moviedb.common.domain.usecase

import com.example.moviedb.common.domain.executer.PostExecutionThread
import io.reactivex.Single

abstract class SingleUseCase<T, in Params> constructor(
    private val postExecutionThread: PostExecutionThread
) : BaseUseCase<T>() {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

}