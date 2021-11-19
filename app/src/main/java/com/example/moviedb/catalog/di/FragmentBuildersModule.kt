package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.ui.fragment.MovieCatalogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Module
abstract class FragmentBuildersModule {

    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun contributeMovieCatalogFragment(): MovieCatalogFragment
}