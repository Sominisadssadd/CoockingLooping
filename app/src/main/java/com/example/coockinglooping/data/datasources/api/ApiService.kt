package com.example.coockinglooping.data.datasources.api

import com.example.coockinglooping.data.model.ListDishesDL
import com.example.coockinglooping.data.utils.GET_DISHES_FROM_API

import retrofit2.http.GET


interface ApiService {
    @GET(GET_DISHES_FROM_API)
    suspend fun getAllDishes(): ListDishesDL
}