package com.example.moviedb.commons.extentions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageFromUrl(
    imgSource: String?,
    useCache: Boolean,
    targetWidth: Int,
    targetHeight: Int,
    placeholder: Drawable,
) {
    val cacheStrategy = when (useCache) {
        false -> DiskCacheStrategy.NONE
        else -> DiskCacheStrategy.AUTOMATIC
    }
    var requestOptions = RequestOptions()
    requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(5))

    Glide
        .with(this)
        .asBitmap()
        .load(imgSource)
        .apply(requestOptions)
        .override(targetWidth, targetHeight)
        .diskCacheStrategy(cacheStrategy)
        .placeholder(placeholder)
        .into(this@setImageFromUrl)
}
