package com.example.moviedb.catalog.data.model

import com.example.moviedb.catalog.data.model.Constants.ADULT
import com.example.moviedb.catalog.data.model.Constants.BACKDROP_PATH
import com.example.moviedb.catalog.data.model.Constants.BELONGS_TO_COLLECTION
import com.example.moviedb.catalog.data.model.Constants.BUDGET
import com.example.moviedb.catalog.data.model.Constants.GENRES
import com.example.moviedb.catalog.data.model.Constants.HOMEPAGE
import com.example.moviedb.catalog.data.model.Constants.ID
import com.example.moviedb.catalog.data.model.Constants.IMDB_ID
import com.example.moviedb.catalog.data.model.Constants.LANGS
import com.example.moviedb.catalog.data.model.Constants.ORIG_LANG
import com.example.moviedb.catalog.data.model.Constants.ORIG_TITLE
import com.example.moviedb.catalog.data.model.Constants.OVERVIEW
import com.example.moviedb.catalog.data.model.Constants.POPULARITY
import com.example.moviedb.catalog.data.model.Constants.POSTER_PATH
import com.example.moviedb.catalog.data.model.Constants.PROD_COMP
import com.example.moviedb.catalog.data.model.Constants.PROD_COUNTRIES
import com.example.moviedb.catalog.data.model.Constants.RELEASE_DATE
import com.example.moviedb.catalog.data.model.Constants.REVENUE
import com.example.moviedb.catalog.data.model.Constants.STATUS
import com.example.moviedb.catalog.data.model.Constants.TAG
import com.example.moviedb.catalog.data.model.Constants.TITLE
import com.example.moviedb.catalog.data.model.Constants.VIDEO
import com.example.moviedb.catalog.data.model.Constants.VOTE_AVERAGE
import com.example.moviedb.catalog.data.model.Constants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class RemoteMovieItem(
    @SerializedName(ADULT) val adult: String?,
    @SerializedName(BACKDROP_PATH) val backdrop_path: String?,
    @SerializedName(BELONGS_TO_COLLECTION) val belongs_to_collection: RemoteMovieItemBelongs?,
    @SerializedName(BUDGET) val budget: String?,
    @SerializedName(GENRES) val genres: List<RemoteMovieItemGenre>?,
    @SerializedName(HOMEPAGE) val homepage: String?,
    @SerializedName(ID) val id: String?,
    @SerializedName(IMDB_ID) val imdb_id: String?,
    @SerializedName(ORIG_LANG) val original_language: String?,
    @SerializedName(ORIG_TITLE) val original_title: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: String?,
    @SerializedName(POSTER_PATH) val poster_path: String?,
    @SerializedName(PROD_COMP) val production_companies: List<RemoteMovieItemProdComp>?,
    @SerializedName(PROD_COUNTRIES) val production_countries: List<RemoteMovieItemProdCount>?,
    @SerializedName(RELEASE_DATE) val release_date: String?,
    @SerializedName(REVENUE) val revenue: String?,
    @SerializedName(LANGS) val spoken_languages: List<RemoteMovieItemLang>?,
    @SerializedName(STATUS) val status: String?,
    @SerializedName(TAG) val tagline: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: String?,
    @SerializedName(VOTE_AVERAGE) val vote_average: String?,
    @SerializedName(VOTE_COUNT) val vote_count: String?

)