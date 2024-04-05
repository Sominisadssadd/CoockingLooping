package com.example.coockinglooping.data.datasources.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://themealdb.com/api/json/v1/1/"
    private fun getRetrofit()

            : Retrofit {
        val client = BaseInterceptor.bodyLoginClient()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
    }

    val apiService = getRetrofit().create(ApiService::class.java)
}