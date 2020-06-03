package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ID
import com.example.moviedb.catalog.data.model.Constants.LOGO_PATH
import com.example.moviedb.catalog.data.model.Constants.NAME
import com.example.moviedb.catalog.data.model.Constants.ORIGIN_COUNTRY
import com.google.gson.annotations.SerializedName

data class RemoteMovieItemProdComp(
    @SerializedName(ID) val id: String?,
    @SerializedName(LOGO_PATH) val logo_path: String?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(ORIGIN_COUNTRY) val origin_country: String?
)