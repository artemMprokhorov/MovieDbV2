package com.example.moviedb.catalog.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedb.MovieDbApp
import com.example.moviedb.catalog.presentation.viewmodel.MovieViewModel
import com.example.moviedb.catalog.ui.fragment.MovieItemDialogFragment
import com.example.moviedb.catalog.ui.util.ImageLoader
import com.example.moviedb.common.di.ViewModelFactory
import com.example.moviedb.common.di.ViewModelKey
import com.example.moviedb.common.presentation.execution.AppExecutionThread
import com.example.moviedb.common.presentation.execution.ExecutionThread
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindInboxViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindExecutionThread(executionThread: AppExecutionThread): ExecutionThread


    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun providesContext(): Context {
            return MovieDbApp.context
        }


        @Provides
        @JvmStatic
        internal fun providesMovieItemDialogFragment(): MovieItemDialogFragment {
            return MovieItemDialogFragment(ImageLoader())
        }

        @Provides
        @JvmStatic
        internal fun providesImageLoader(): ImageLoader {
            return ImageLoader()
        }

    }

}