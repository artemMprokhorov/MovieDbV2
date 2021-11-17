package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.ui.activity.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieActivity(): MovieActivity
}