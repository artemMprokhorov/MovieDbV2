package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ADULT
import com.example.moviedb.catalog.data.model.Constants.BACKDROP_PATH
import com.example.moviedb.catalog.data.model.Constants.ID
import com.example.moviedb.catalog.data.model.Constants.ORIG_LANG
import com.example.moviedb.catalog.data.model.Constants.ORIG_TITLE
import com.example.moviedb.catalog.data.model.Constants.OVERVIEW
import com.example.moviedb.catalog.data.model.Constants.POPULARITY
import com.example.moviedb.catalog.data.model.Constants.POSTER_PATH
import com.example.moviedb.catalog.data.model.Constants.RELEASE_DATE
import com.example.moviedb.catalog.data.model.Constants.TITLE
import com.example.moviedb.catalog.data.model.Constants.VIDEO
import com.example.moviedb.catalog.data.model.Constants.VOTE_AVERAGE
import com.example.moviedb.catalog.data.model.Constants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class RemotePopularItem(
    @SerializedName(POPULARITY) val popularity: String?,
    @SerializedName(VOTE_COUNT) val voteCount: Long?,
    @SerializedName(VIDEO) val video: Boolean?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(ID) val id: String?,
    @SerializedName(ADULT) val adult: String?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(ORIG_LANG) val originalLanguage: String?,
    @SerializedName(ORIG_TITLE) val originalTitle: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?
)