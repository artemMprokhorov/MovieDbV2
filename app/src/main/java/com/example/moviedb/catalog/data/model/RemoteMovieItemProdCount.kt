package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ISO_3166_1
import com.example.moviedb.catalog.data.model.Constants.NAME
import com.google.gson.annotations.SerializedName

data class RemoteMovieItemProdCount(
    @SerializedName(ISO_3166_1) val iso: String?,
    @SerializedName(NAME) val name: String?
)