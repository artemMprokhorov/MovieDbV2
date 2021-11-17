package com.example.moviedb.catalog.di

import android.app.Application
import com.example.moviedb.MovieDbApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        PresentationModule::class,
        RemoteModule::class,
        DataModule::class,
        ContextModule::class,
        AndroidInjectionModule::class
    ]
)

interface AppComponent : AndroidInjector<MovieDbApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: MovieDbApp)
}
