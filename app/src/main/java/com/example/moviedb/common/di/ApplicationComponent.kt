package com.example.moviedb.common.di

import android.content.Context
import com.example.moviedb.MovieDbApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class
    ]
)

interface ApplicationComponent : AndroidInjector<MovieDbApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    override fun inject(movieDbApp: MovieDbApp?)
}