package com.example.moviedb.commons.threads

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}