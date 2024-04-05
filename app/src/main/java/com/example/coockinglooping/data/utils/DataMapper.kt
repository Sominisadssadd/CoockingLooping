package com.example.coockinglooping.data.utils

import com.example.coockinglooping.data.model.ListDishesDL
import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.model.ListDishes

fun ListDishesDL.convertListOfDishesToDomainLOD() : ListDishes{
    val domainDishesList = mutableListOf<Dish>()
    for (dishDL in meals) {
        val dish = Dish(
            idMeal = dishDL.idMeal,
            name = dishDL.strMeal,
            description = dishDL.strInstructions,
            imageUrl = dishDL.strMealThumb,
            cost = dishDL.strMeasure1
        )
        domainDishesList.add(dish)
    }
    return ListDishes(meals = domainDishesList)
}