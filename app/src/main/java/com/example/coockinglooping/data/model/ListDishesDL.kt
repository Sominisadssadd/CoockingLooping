package com.example.coockinglooping.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListDishesDL(
    @SerialName("meals")
    val meals: List<Dish>
)