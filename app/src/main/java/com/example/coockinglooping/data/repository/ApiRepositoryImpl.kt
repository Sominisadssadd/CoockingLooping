package com.example.coockinglooping.data.repository

import com.example.coockinglooping.data.datasources.api.RetrofitInstance
import com.example.coockinglooping.data.model.ListDishesDL
import com.example.coockinglooping.data.utils.convertListOfDishesToDomainLOD
import com.example.coockinglooping.domain.model.ListDishes
import com.example.coockinglooping.domain.repository.DishesRepositoryApi

class ApiRepositoryImpl : DishesRepositoryApi {

    private val apiService = RetrofitInstance.apiService
    override suspend fun getAllDishes(): ListDishes {
        return apiService.getAllDishes().convertListOfDishesToDomainLOD()
    }
}