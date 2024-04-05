package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCaseGetAllDishesByFilters(private val repository: DishesRepositoryDb) {
    operator fun invoke(filterName: String) = flow {
        emit(repository.filterDishes(filterName))
    }
}