package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.ui.activity.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.FlowPreview

@Module
abstract class ActivityBuilderModule {

    @FlowPreview
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )

    abstract fun contributeMovieActivity(): MovieActivity
}