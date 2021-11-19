package com.example.moviedb.commons.threads

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AppCoroutineExecutionThread @Inject constructor() : CoroutineExecutionThread {

    override fun uiThread(): CoroutineDispatcher = Dispatchers.Main

    override fun ioThread(): CoroutineDispatcher = Dispatchers.IO
}