package com.example.moviedb.catalog.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.moviedb.R

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_error, this)
        setBackgroundWithTransparency()
    }

    private fun setBackgroundWithTransparency() {
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhiteTransparent))
    }
}