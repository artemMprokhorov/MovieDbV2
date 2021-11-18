package com.example.moviedb.catalog.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedb.catalog.presentation.MovieViewModel
import com.example.moviedb.catalog.ui.fragment.MovieItemDialogFragment
import com.example.moviedb.commons.factory.ViewModelFactory
import com.example.moviedb.commons.factory.ViewModelKey
import com.example.moviedb.commons.threads.AppExecutionThread
import com.example.moviedb.commons.threads.ExecutionThread
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindExecutionThread(executionThread: AppExecutionThread): ExecutionThread

    companion object {

        @Provides
        internal fun providesMovieItemDialogFragment(): MovieItemDialogFragment {
            return MovieItemDialogFragment()
        }
    }
}