package com.challenge.fetchcats.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val BASE_URL = "https://api.imgur.com/"
    const val AUTHORIZATION_KEY = "Client-ID 1ceddedc03a5d71"

    val api : API by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}