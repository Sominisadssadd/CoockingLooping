package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryApi
import kotlinx.coroutines.flow.flow

class UseCaseGetAllDishesFromApi(private val repository: DishesRepositoryApi) {
    operator fun invoke() = flow {
        emit(repository.getAllDishes())
    }
}