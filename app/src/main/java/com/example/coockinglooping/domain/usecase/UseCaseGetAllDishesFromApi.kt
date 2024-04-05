package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryApi

class UseCaseGetAllDishesFromApi(private val repository: DishesRepositoryApi) {
    operator fun invoke(): List<Dish> {
        return repository.getAllDishes()
    }
}