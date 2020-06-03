package com.example.moviedb.common.domain.executer

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}