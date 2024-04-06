package com.example.coockinglooping.data.utils


//Api queries

const val GET_DISHES_FROM_API = "search.php?s"
const val GET_DISHES_FROM_DB = ""
const val GET_DISHES_BY_FILTERS = ""

//Database queries
const val QUERY_GET_LIST_OF_DISHES = "select * from dishes"
const val QUERY_GET_FILTERED_LIST_OF_DISHES = "select * from dishes where categoryDish in (:categoriesFilter) "

//Db other
const val DISH_TABLE_NAME = "dishes"
const val DATABASE_VERSION = 1
const val FIELD_ID = "idDish"
const val FIELD_NAME = "nameDish"
const val FIELD_DESCRIPTION = "descriptionDish"
const val FIELD_IMAGE_URL = "imurlDish"
const val FIELD_COST = "costDish"
const val FIELD_CATEGORY = "categoryDish"
const val DB_NAME = "dishesDB"
