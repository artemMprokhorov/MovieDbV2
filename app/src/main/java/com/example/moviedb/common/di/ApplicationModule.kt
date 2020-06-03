package com.example.moviedb.common.di

import com.example.moviedb.common.domain.executer.PostExecutionThread
import com.example.moviedb.common.presentation.execution.UiThread
import dagger.Binds
import dagger.Module

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule

@Module
abstract class ApplicationModuleBinds {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread
}