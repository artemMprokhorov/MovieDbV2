package com.example.moviedb.catalog.domain.usecase

import com.example.moviedb.catalog.domain.model.DomainMovieItem
import com.example.moviedb.catalog.domain.repo.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieItemUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun execute(params: String): Single<DomainMovieItem> = repository.getMovieItem(params)
}