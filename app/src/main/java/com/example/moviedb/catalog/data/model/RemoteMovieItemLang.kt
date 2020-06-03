package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ISO_639_1
import com.example.moviedb.catalog.data.model.Constants.NAME
import com.google.gson.annotations.SerializedName

data class RemoteMovieItemLang(
    @SerializedName(ISO_639_1) val iso: String?,
    @SerializedName(NAME) val name: String?
)