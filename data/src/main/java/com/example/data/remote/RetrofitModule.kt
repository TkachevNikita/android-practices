package com.example.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitModule {

    private const val BASE_URL = "https://api.kinopoisk.dev/v1.4/"

    val getRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL).build().create(MovieAPI::class.java)
}