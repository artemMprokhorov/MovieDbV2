package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.BACKDROP_PATH
import com.example.moviedb.catalog.data.model.Constants.ID
import com.example.moviedb.catalog.data.model.Constants.NAME
import com.example.moviedb.catalog.data.model.Constants.POSTER_PATH
import com.google.gson.annotations.SerializedName

data class RemoteMovieItemBelongs(
    @SerializedName(ID) val id: String?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?
)