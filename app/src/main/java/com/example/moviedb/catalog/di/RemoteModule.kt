package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.data.remote.MovieRestApi
import com.example.moviedb.catalog.data.remote.MovieRestApiImpl
import com.example.moviedb.catalog.data.source.MovieApiDataSource
import com.example.moviedb.catalog.data.source.MovieDataSource
import com.example.moviedb.common.domain.executer.PostExecutionThread
import com.example.moviedb.common.presentation.execution.UiThread
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun provideInboxDataSource(
            movieRestApi: MovieRestApi
        ): MovieDataSource {
            return MovieApiDataSource(movieRestApi)
        }

        @Provides
        @JvmStatic
        internal fun provideInboxRestApi(
        ): MovieRestApi {
            return MovieRestApiImpl()
        }
    }

}