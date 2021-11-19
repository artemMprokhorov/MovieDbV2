package com.example.moviedb.catalog.di

import android.content.Context
import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.remote.MovieRestApi
import com.example.moviedb.catalog.data.remote.MovieRestApiImpl
import com.example.moviedb.catalog.data.source.MovieDataSource
import com.example.moviedb.commons.net.FakeInterceptor
import com.example.moviedb.commons.threads.PostExecutionThread
import com.example.moviedb.commons.threads.UiThread
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory

@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @Binds
    abstract fun bindLifeInsuranceRemote(movieRestApiImpl: MovieRestApiImpl): MovieDataSource

    companion object {

        @Provides
        internal fun provideMovieApiService(context: Context): MovieRestApi {
            val okHttpBuilder = OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .socketFactory(SocketFactory.getDefault())

            if (BuildConfig.FLAVOR.equals("dummy")) {
                okHttpBuilder.addInterceptor(FakeInterceptor(context))
            }

            return Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieRestApi::class.java)
        }
    }
}