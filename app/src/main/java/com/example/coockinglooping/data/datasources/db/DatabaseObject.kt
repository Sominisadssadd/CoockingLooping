package com.example.coockinglooping.data.datasources.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coockinglooping.data.datasources.db.dao.DishDao
import com.example.coockinglooping.data.datasources.db.entities.DishEntity
import com.example.coockinglooping.data.utils.DATABASE_VERSION
import com.example.coockinglooping.data.utils.DB_NAME


@Database(version = DATABASE_VERSION, entities = [DishEntity::class])
abstract class DatabaseObject : RoomDatabase() {
    abstract fun getStaticDao(): DishDao

    companion object {

        @Volatile
        private var INSTANCE: DatabaseObject? = null

        fun getDataBase(context: Context): DatabaseObject {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }

            return INSTANCE ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context): DatabaseObject {
            return Room.databaseBuilder(
                context.applicationContext,
                DatabaseObject::class.java,
                DB_NAME
            ).build()
        }

    }
}