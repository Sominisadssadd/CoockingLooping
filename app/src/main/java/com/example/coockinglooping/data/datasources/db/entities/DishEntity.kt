package com.example.coockinglooping.data.datasources.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coockinglooping.data.utils.DISH_TABLE_NAME
import com.example.coockinglooping.data.utils.FIELD_CATEGORY
import com.example.coockinglooping.data.utils.FIELD_COST
import com.example.coockinglooping.data.utils.FIELD_DESCRIPTION
import com.example.coockinglooping.data.utils.FIELD_ID
import com.example.coockinglooping.data.utils.FIELD_IMAGE_URL
import com.example.coockinglooping.data.utils.FIELD_NAME

@Entity(tableName = DISH_TABLE_NAME)
data class DishEntity(

    @PrimaryKey
    @ColumnInfo(name = FIELD_ID)
    val id: Int,
    @ColumnInfo(name = FIELD_NAME)
    val dishName: String,
    @ColumnInfo(name = FIELD_DESCRIPTION)
    val dishDescription: String,
    @ColumnInfo(name = FIELD_IMAGE_URL)
    val dishImageUrl: String,
    @ColumnInfo(name = FIELD_COST)
    val dishCost: String,
    @ColumnInfo(name = FIELD_CATEGORY)
    val dishCategory: String
)