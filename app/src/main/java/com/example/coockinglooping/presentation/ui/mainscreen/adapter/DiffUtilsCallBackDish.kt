package com.example.coockinglooping.presentation.ui.mainscreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.coockinglooping.presentation.model.DishPL

class DiffUtilsCallBackDish : DiffUtil.ItemCallback<DishPL>() {
    override fun areItemsTheSame(oldItem: DishPL, newItem: DishPL) =
        oldItem.idMeal == newItem.idMeal

    override fun areContentsTheSame(oldItem: DishPL, newItem: DishPL) =
        oldItem == newItem
}