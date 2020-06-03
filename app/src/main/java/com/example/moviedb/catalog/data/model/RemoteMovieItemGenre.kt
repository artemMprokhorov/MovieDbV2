package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ID
import com.example.moviedb.catalog.data.model.Constants.NAME
import com.google.gson.annotations.SerializedName

data class RemoteMovieItemGenre(
    @SerializedName(ID) val id: String?,
    @SerializedName(NAME) val name: String?
)