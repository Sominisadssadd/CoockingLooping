package com.example.coockinglooping.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DishDL(
    @SerialName(FIELDS_ID) val idMeal: Int,
    @SerialName(FIELDS_NAME) val strMeal: String,
    @SerialName(FIELDS_DESCRIPTION) val strInstructions: String,
    @SerialName(FIELDS_IMAGE_URL) val strMealThumb: String,
    @SerialName(FIELDS_COST) val strMeasure1: String,
    @SerialName(FIELDS_CATEGORY) val strCategory: String


) {
    companion object {
        private const val FIELDS_ID = "idMeal"
        private const val FIELDS_NAME = "strMeal"
        private const val FIELDS_DESCRIPTION = "strInstructions"
        private const val FIELDS_IMAGE_URL = "strMealThumb"
        private const val FIELDS_COST = "strMeasure1"
        private const val FIELDS_CATEGORY = "strCategory"
    }
}