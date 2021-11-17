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
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(BELONGS_TO_COLLECTION) val belongsToCollection: RemoteMovieItemBelongs?,
    @SerializedName(BUDGET) val budget: String?,
    @SerializedName(GENRES) val genres: List<RemoteMovieItemGenre>?,
    @SerializedName(HOMEPAGE) val homepage: String?,
    @SerializedName(ID) val id: String?,
    @SerializedName(IMDB_ID) val imdbId: String?,
    @SerializedName(ORIG_LANG) val originalLanguage: String?,
    @SerializedName(ORIG_TITLE) val originalTitle: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: String?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(PROD_COMP) val productionCompanies: List<RemoteMovieItemProdComp>?,
    @SerializedName(PROD_COUNTRIES) val productionCountries: List<RemoteMovieItemProdCount>?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(REVENUE) val revenue: String?,
    @SerializedName(LANGS) val spokenLanguages: List<RemoteMovieItemLang>?,
    @SerializedName(STATUS) val status: String?,
    @SerializedName(TAG) val tagline: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: String?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: String?,
    @SerializedName(VOTE_COUNT) val voteCount: String?
)