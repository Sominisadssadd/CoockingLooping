package com.example.coockinglooping.data.repository

import android.content.Context
import com.example.coockinglooping.data.datasources.db.DatabaseObject
import com.example.coockinglooping.data.utils.convertListOfDishEntitiesToDomainLOD
import com.example.coockinglooping.data.utils.convertListOfDishesToDbDishEntity
import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.repository.DishesRepositoryDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DbRepositoryImpl(context: Context) : DishesRepositoryDb {

    val dataDAO = DatabaseObject.getDataBase(context).getStaticDao()
    override suspend fun getAllDishes(): List<Dish> {
        return withContext(Dispatchers.IO) {
            return@withContext dataDAO.getListOfDishesFromDb()
                .convertListOfDishEntitiesToDomainLOD()
        }
    }

    override suspend fun filterDishes(category: List<String>): List<Dish> {
        return withContext(Dispatchers.IO) {
            return@withContext dataDAO.getListOfDishesByCategory(category)
                .convertListOfDishEntitiesToDomainLOD()
        }
    }
    override suspend fun addDishes(dishes: List<Dish>) {
        withContext(Dispatchers.IO) {
            dataDAO.insertDishesEntitiesList(dishes.convertListOfDishesToDbDishEntity())
        }
    }
}