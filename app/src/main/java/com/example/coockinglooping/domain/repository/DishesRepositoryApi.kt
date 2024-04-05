package com.example.coockinglooping.domain.repository

import com.example.coockinglooping.domain.model.Dish

interface DishesRepositoryApi {

    fun getAllDishes(): List<Dish>
}