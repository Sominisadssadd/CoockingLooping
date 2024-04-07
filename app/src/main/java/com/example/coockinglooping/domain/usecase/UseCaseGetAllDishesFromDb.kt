package com.example.coockinglooping.domain.usecase

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UseCaseGetAllDishesFromDb(private val repository: DishesRepositoryDb) {
    operator fun invoke() = flow {
            emit(repository.getAllDishes())
    }

}