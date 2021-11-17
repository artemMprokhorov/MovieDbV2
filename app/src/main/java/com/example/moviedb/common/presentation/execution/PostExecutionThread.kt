package com.example.moviedb.common.presentation.execution

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}