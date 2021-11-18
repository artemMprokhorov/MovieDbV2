package com.vladus177.albums.di

import com.example.moviedb.catalog.ui.fragment.MovieCatalogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieCatalogFragment(): MovieCatalogFragment
}