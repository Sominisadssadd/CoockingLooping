package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb

class UseCaseInsertDishesToDb(private val repository: DishesRepositoryDb) {
    suspend operator fun invoke(dishes: List<Dish>) {
        repository.addDishes(dishes)
    }
}