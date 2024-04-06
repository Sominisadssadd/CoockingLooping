package com.example.coockinglooping.domain.repository

import com.example.coockinglooping.domain.model.Dish

interface DishesRepositoryDb {

    suspend fun getAllDishes(): List<Dish>

    suspend fun filterDishes(category: List<String>): List<Dish>

    suspend fun addDishes(dishes: List<Dish>)

}