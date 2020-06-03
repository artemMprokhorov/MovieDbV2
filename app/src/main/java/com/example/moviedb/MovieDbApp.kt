package com.example.moviedb

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.moviedb.common.di.ApplicationComponent
import com.example.moviedb.common.di.DaggerApplicationComponent

open class MovieDbApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        restrictDarkMode()
        onInjectApplication()
    }

    private fun restrictDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun onInjectApplication() {
        applicationComponent =
            DaggerApplicationComponent.factory().create(applicationContext)
        applicationComponent!!.inject(this)
    }


    companion object {
        var applicationComponent: ApplicationComponent? = null
            private set

        lateinit var context: Context
            private set

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

}