package com.example.moviedb.catalog.domain.usecase

import com.example.moviedb.catalog.domain.model.DomainPopular
import com.example.moviedb.catalog.domain.repo.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun execute(params: String): Single<DomainPopular> = repository.getPopular(params)
}