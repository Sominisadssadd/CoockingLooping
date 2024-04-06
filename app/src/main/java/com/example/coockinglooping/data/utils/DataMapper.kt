package com.example.coockinglooping.data.utils

import com.example.coockinglooping.data.datasources.db.entities.DishEntity
import com.example.coockinglooping.data.model.ListDishesDL
import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.model.ListDishes

fun ListDishesDL.convertListOfDishesToDomainLOD(): ListDishes {
    val domainDishesList = mutableListOf<Dish>()
    for (dishDL in meals) {
        val dish = Dish(
            idMeal = dishDL.idMeal,
            name = dishDL.strMeal,
            description = dishDL.strInstructions,
            imageUrl = dishDL.strMealThumb,
            cost = dishDL.strMeasure1,
            category = dishDL.strCategory
        )
        domainDishesList.add(dish)
    }
    return ListDishes(meals = domainDishesList)
}

fun List<Dish>.convertListOfDishesToDbDishEntity(): List<DishEntity> {
    val databaseDishesList = mutableListOf<DishEntity>()
    for (dishDL in this) {
        val dishEntity = DishEntity(
            id = dishDL.idMeal,
            dishName = dishDL.name,
            dishDescription = dishDL.description,
            dishImageUrl = dishDL.imageUrl,
            dishCost = dishDL.cost,
            dishCategory = dishDL.category
        )
        databaseDishesList.add(dishEntity)
    }
    return databaseDishesList
}

fun List<DishEntity>.convertListOfDishEntitiesToDomainLOD(): List<Dish> {
    val domainDishesList = mutableListOf<Dish>()
    for (dishDL in this) {
        val dish = Dish(
            idMeal = dishDL.id,
            name = dishDL.dishName,
            description = dishDL.dishDescription,
            imageUrl = dishDL.dishImageUrl,
            cost = dishDL.dishCost,
            category = dishDL.dishCategory
        )
        domainDishesList.add(dish)
    }
    return domainDishesList
}