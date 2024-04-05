package com.example.coockinglooping.domain.repository

import com.example.coockinglooping.domain.model.Dish

interface DishesRepositoryDb {

    fun getAllDishes(): List<Dish>

    fun filterDishes(category: String): List<Dish>

}