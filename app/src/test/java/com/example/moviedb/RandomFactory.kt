package com.example.moviedb

import java.util.*

object RandomFactory {

    fun generateString(): String = UUID.randomUUID().toString()
    fun generateBoolean(): Boolean = Math.random() < 0.5
    fun generateLong(): Long = Random().nextLong()

}