package com.example.moviedb.catalog.di

import com.example.moviedb.catalog.data.repo.MovieDataRepository
import com.example.moviedb.catalog.domain.repo.MovieRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindInboxDataRepository(dataRepository: MovieDataRepository): MovieRepository

}