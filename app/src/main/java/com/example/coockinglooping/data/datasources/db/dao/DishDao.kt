package com.example.coockinglooping.data.datasources.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coockinglooping.data.datasources.db.entities.DishEntity
import com.example.coockinglooping.data.utils.QUERY_GET_FILTERED_LIST_OF_DISHES
import com.example.coockinglooping.data.utils.QUERY_GET_LIST_OF_DISHES
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDishesEntitiesList(dishList: List<DishEntity>)
    @Query(QUERY_GET_LIST_OF_DISHES)
    fun getListOfDishesFromDb(): List<DishEntity>
    @Query(QUERY_GET_FILTERED_LIST_OF_DISHES)
    fun getListOfDishesByCategory(categoriesFilter: List<String>): List<DishEntity>
}

