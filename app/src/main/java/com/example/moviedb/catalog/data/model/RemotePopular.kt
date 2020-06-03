package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.PAGE
import com.example.moviedb.catalog.data.model.Constants.RESULTS
import com.example.moviedb.catalog.data.model.Constants.TOTAL_PAGES
import com.example.moviedb.catalog.data.model.Constants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class RemotePopular(
    @SerializedName(PAGE) val page: Long?,
    @SerializedName(TOTAL_RESULTS) val total_results: Long?,
    @SerializedName(TOTAL_PAGES) val total_pages: Long?,
    @SerializedName(RESULTS) val results: List<RemotePopularItem>?
)