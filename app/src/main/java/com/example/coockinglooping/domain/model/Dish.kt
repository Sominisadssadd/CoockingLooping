package com.example.coockinglooping.domain.model

data class Dish(
    private val idMeal: Int,
    private val name: String,
    private val description: String,
    private val imageUrl: String,
    private val cost: Int
)