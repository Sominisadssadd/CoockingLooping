package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb

class UseCaseGetAllDishesFromDb(private val repository: DishesRepositoryDb) {
    operator fun invoke(): List<Dish> {
        return repository.getAllDishes()
    }
}