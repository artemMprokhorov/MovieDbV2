package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.PAGE
import com.example.moviedb.catalog.data.model.Constants.RESULTS
import com.example.moviedb.catalog.data.model.Constants.TOTAL_PAGES
import com.example.moviedb.catalog.data.model.Constants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class RemotePopular(
    @SerializedName(PAGE) val page: Long?,
    @SerializedName(TOTAL_RESULTS) val totalResults: Long?,
    @SerializedName(TOTAL_PAGES) val totalPages: Long?,
    @SerializedName(RESULTS) val results: List<RemotePopularItem>?
)