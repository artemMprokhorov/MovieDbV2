package com.example.moviedb.commons.mvi

class UnsupportedReduceException(state: MviState, result: MviResult) :
    RuntimeException("Cannot reduce state: $state with result: $result")