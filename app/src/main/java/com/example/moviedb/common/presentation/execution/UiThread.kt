package com.example.moviedb.common.presentation.execution

import com.example.moviedb.common.domain.executer.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class UiThread @Inject constructor() : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}