package com.example.moviedb.catalog.ui.util

import android.animation.ObjectAnimator
import android.graphics.drawable.Drawable
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviedb.MovieDbApp
import com.example.moviedb.R
import com.example.moviedb.catalog.ui.util.Constants.DURATION
import com.example.moviedb.catalog.ui.util.Constants.PATH
import com.example.moviedb.catalog.ui.util.Constants.PROPERTY_NAME
import com.example.moviedb.catalog.ui.util.Constants.ROUNDING_RADIUS
import com.example.moviedb.catalog.ui.util.Constants.VALUES


class ImageLoader {

    fun setImage(imageView: ImageView, baseUrl: String, img: String, width: Int, height: Int) {
        val placeholder: Drawable? = getDrawableLoading()
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(ROUNDING_RADIUS))
        Glide.with(MovieDbApp.context)
            .load(baseUrl + img)
            .apply(requestOptions)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(width, height)
            .placeholder(placeholder)
            .into(imageView)

    }

    private fun getDrawableLoading(): Drawable? {
        val drawable: Drawable? =
            MovieDbApp.context.getDrawable(R.drawable.ic_error)
        val objectAnimator = ObjectAnimator.ofInt(drawable, PROPERTY_NAME, VALUES, PATH)
        objectAnimator.duration = DURATION
        objectAnimator.repeatCount = Animation.INFINITE
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.start()
        return drawable
    }
}