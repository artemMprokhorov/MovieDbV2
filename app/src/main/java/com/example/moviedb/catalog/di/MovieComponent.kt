package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.ui.activity.MovieActivity
import com.example.moviedb.common.di.ActivityScope
import com.example.moviedb.common.di.ApplicationComponent
import dagger.Component

@ActivityScope
@Component(
    modules = [PresentationModule::class, RemoteModule::class, DataModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MovieComponent {

    fun inject(movieActivity: MovieActivity)

}
