package com.example.coockinglooping.domain.repository

import com.example.coockinglooping.domain.model.ListDishes


interface DishesRepositoryApi {

    suspend fun getAllDishes(): ListDishes
}