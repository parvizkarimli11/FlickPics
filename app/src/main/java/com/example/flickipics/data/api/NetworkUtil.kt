package com.example.flickipics.data.api

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkUtil {

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val moshi = Moshi.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl.BASE_URL) // set in BuildConfig (see below)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val usersApi: MovieService = retrofit.create(MovieService::class.java)

}