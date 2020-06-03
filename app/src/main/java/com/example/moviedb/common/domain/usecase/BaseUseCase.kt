package com.example.moviedb.common.domain.usecase

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseUseCase<T> {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    fun remove(disposable: Disposable?) {
        if (disposable != null) compositeDisposable.remove(disposable)
    }

    fun add(disposable: Disposable?) {
        if (disposable != null) compositeDisposable.add(disposable)
    }

}