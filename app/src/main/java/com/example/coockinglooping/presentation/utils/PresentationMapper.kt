package com.example.coockinglooping.presentation.utils

import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.presentation.model.DishPL

fun List<Dish>.listOfDishesDomainToDishPL(): List<DishPL> {
    val presentationDishesList = mutableListOf<DishPL>()
    for (dish in this) {
        val dish = DishPL(
            idMeal = dish.idMeal,
            name = dish.name,
            description = dish.description,
            imageUrl = dish.imageUrl,
            cost = dish.cost,
            category = dish.category
        )
        presentationDishesList.add(dish)
    }
    return presentationDishesList
}


fun Dish.dishDomainToDishPL() : DishPL{
    val dish = DishPL(
        idMeal =this.idMeal,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl,
        cost = this.cost,
        category = this.category
    )
    return dish
}