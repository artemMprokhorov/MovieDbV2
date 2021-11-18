package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.ui.activity.MovieActivity
import com.vladus177.albums.di.FragmentBuildersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )

    abstract fun contributeMovieActivity(): MovieActivity
}