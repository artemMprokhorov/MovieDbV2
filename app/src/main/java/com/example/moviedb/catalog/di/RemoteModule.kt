package com.example.moviedb.catalog.di

import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.data.remote.MovieRestApi
import com.example.moviedb.catalog.data.remote.MovieRestApiImpl
import com.example.moviedb.catalog.data.source.MovieApiDataSource
import com.example.moviedb.catalog.data.source.MovieDataSource
import com.example.moviedb.common.presentation.execution.PostExecutionThread
import com.example.moviedb.common.presentation.execution.UiThread
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory

@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun provideMovieApiService(): MovieRestApi {
            val okHttpBuilder = OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .socketFactory(SocketFactory.getDefault())

            if (BuildConfig.DEBUG) {
                val httpLogInterceptor = HttpLoggingInterceptor()
                httpLogInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okHttpBuilder.addInterceptor(httpLogInterceptor)
            }


            return Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieRestApi::class.java)
        }

        @Provides
        @JvmStatic
        internal fun provideMovieDataSource(
            movieRestApi: MovieRestApi
        ): MovieDataSource {
            return MovieApiDataSource(movieRestApi)
        }

        @Provides
        @JvmStatic
        internal fun provideMovieRestApi(
            restApi: MovieRestApi
        ): MovieRestApiImpl {
            return MovieRestApiImpl(restApi)
        }
    }
}