package com.example.moviedb.common.presentation.execution

import io.reactivex.Scheduler

interface ExecutionThread {

    fun schedulerForObserving(): Scheduler

    fun schedulerForSubscribing(): Scheduler

}