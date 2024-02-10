package com.example.laboratoryworkapplication.di

import com.example.laboratoryworkapplication.BuildConfig
import com.example.laboratoryworkapplication.data.network.ApiService
import com.example.laboratoryworkapplication.data.network.AuthInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiServiceModule = module {
    single<Gson> {
        GsonBuilder()
            .create()
    }

    single<ApiService> {
        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(BuildConfig.KEY))
            .build()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(/* gson = */ get()))
            .build()
            .create(ApiService::class.java)
    }
}