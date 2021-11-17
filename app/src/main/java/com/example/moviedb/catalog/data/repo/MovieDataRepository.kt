package com.example.moviedb.catalog.data.repo

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.mapper.*
import com.example.moviedb.catalog.data.source.MovieDataSource
import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.domain.model.DomainPopular
import com.example.moviedb.catalog.domain.repo.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val popularMapper: PopularMapper,
    private val popularItemMapper: PopularItemMapper,
    private val movieItemMapper: MovieItemMapper,
    private val movieItemLangMapper: MovieItemLangMapper,
    private val movieItemProdCountMapper: MovieItemProdCountMapper,
    private val movieItemProdCompMapper: MovieItemProdCompMapper,
    private val movieItemGenresMapper: MovieItemGenresMapper,
    private val movieItemBelongsMapper: MovieItemBelongsMapper
) : MovieRepository {

    override fun getPopular(pageNum: String): Single<DomainPopular> {
        return movieDataSource.getPopular(pageNum, getApiKey()).map {
            with(popularMapper) { it.fromRemoteToDomain(popularItemMapper) }
        }
    }

    override fun getMovieItem(movieId: String): Single<DomainMovieItem> =
        movieDataSource
            .getMovieItem(movieId, getApiKey())
            .map {
                with(movieItemMapper) {
                    it.toDomain(
                        movieItemLangMapper,
                        movieItemProdCountMapper,
                        movieItemProdCompMapper,
                        movieItemGenresMapper,
                        movieItemBelongsMapper
                    )
                }
            }

    private fun getApiKey(): String = BuildConfig.API_KEY

}