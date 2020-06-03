package com.example.moviedb.common.network


abstract class BaseApiClient<T, K, V> {
    var apiService: T? = null
    private var errorHandlers: List<V>? = null
    protected fun createService() {
        apiService = initApi(initClient())
    }

    protected abstract fun initApi(client: K): T
    protected abstract fun initClient(): K
    protected abstract fun getApiService(): Class<T>?

}