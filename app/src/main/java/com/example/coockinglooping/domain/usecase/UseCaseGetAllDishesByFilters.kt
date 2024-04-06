package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.repository.DishesRepositoryDb
import kotlinx.coroutines.flow.flow

class UseCaseGetAllDishesByFilters(private val repository: DishesRepositoryDb) {
    operator fun invoke(filterName: List<String>) = flow {
        emit(repository.filterDishes(filterName))
    }
}