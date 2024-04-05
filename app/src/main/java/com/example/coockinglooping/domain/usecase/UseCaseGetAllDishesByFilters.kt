package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb

class UseCaseGetAllDishesByFilters(private val repository: DishesRepositoryDb) {
    operator fun invoke(filterName: String): List<Dish> {
        return repository.filterDishes(filterName)
    }
}