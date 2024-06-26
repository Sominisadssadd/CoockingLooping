package com.example.coockinglooping.data.datasources.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object BaseInterceptor {

    fun bodyLoginClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return client
    }
}