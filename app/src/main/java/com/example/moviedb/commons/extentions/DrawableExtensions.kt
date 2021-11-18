package com.example.moviedb.commons.extentions

import android.content.Context
import androidx.core.content.ContextCompat

fun Int.getFromResId(context: Context) =
    ContextCompat.getDrawable(context, this)
