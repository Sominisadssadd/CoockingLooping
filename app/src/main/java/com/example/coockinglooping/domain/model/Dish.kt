package com.example.coockinglooping.domain.model

data class Dish(
    val idMeal: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val cost: String,
    val category: String
)