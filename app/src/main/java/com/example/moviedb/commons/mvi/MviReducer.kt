package com.example.moviedb.commons.mvi

interface MviReducer<S, R> {
    infix fun S.reduce(result: R): S
}