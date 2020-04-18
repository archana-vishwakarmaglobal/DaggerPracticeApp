package com.firebase.daggerpractceapp.dagger

import com.firebase.daggerpractceapp.User
import com.firebase.daggerpractceapp.model.RetrofitRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
@Module
class APIModule constructor(baseurl: String) {
    var baseurl: String? = null

    init {
        this.baseurl = baseurl
    }

    @Provides
    fun provideOKHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(1200, TimeUnit.MILLISECONDS)
                .connectTimeout(1200, TimeUnit.MILLISECONDS)
                .build()
    }

    @Provides
    fun provideGSON(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseurl).addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    fun provideRetrofitRepository():RetrofitRepository{
        return RetrofitRepository()
    }

}