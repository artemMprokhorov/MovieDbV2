package com.example.moviedb.catalog.ui.activity

import android.os.Bundle
import com.example.moviedb.R
import dagger.android.support.DaggerAppCompatActivity

class MovieActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }
}
