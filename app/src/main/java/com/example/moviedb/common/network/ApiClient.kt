package com.example.moviedb.common.network

import com.example.moviedb.BuildConfig
import com.example.moviedb.common.network.Constants.TIME_OUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory

abstract class ApiClient<T> :
    BaseApiClient<T, OkHttpClient, Interceptor>() {

    override fun initApi(client: OkHttpClient): T {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(getApiService())
    }

    override fun initClient(): OkHttpClient {
        return initRetrofit()
    }

    override fun getApiService(): Class<T>? {
        return null
    }

    private fun initRetrofit(): OkHttpClient {
        val httpLogInterceptor = HttpLoggingInterceptor()
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.socketFactory(SocketFactory.getDefault())
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        httpLogInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLogInterceptor)
        return okHttpBuilder.build()
    }

    companion object {
        private const val baseURL: String = BuildConfig.API_URL
    }
}