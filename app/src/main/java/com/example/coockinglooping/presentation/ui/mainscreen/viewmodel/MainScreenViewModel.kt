package com.example.coockinglooping.presentation.ui.mainscreen.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.BuiltInTypeConverters.State
import com.example.coockinglooping.data.repository.ApiRepositoryImpl
import com.example.coockinglooping.data.repository.DbRepositoryImpl
import com.example.coockinglooping.domain.usecase.UseCaseGetAllDishesByFilters
import com.example.coockinglooping.domain.usecase.UseCaseGetAllDishesFromApi
import com.example.coockinglooping.domain.usecase.UseCaseGetAllDishesFromDb
import com.example.coockinglooping.domain.usecase.UseCaseInsertDishesToDb
import com.example.coockinglooping.presentation.ui.mainscreen.state.MainScreenState
import com.example.coockinglooping.presentation.utils.listOfDishesDomainToDishPL
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class MainScreenViewModel(context: Context) : ViewModel() {

    val dbRepositoryImpl = DbRepositoryImpl(context)
    val apiRepositoryImpl = ApiRepositoryImpl()
    val useCaseInsertDishesToDb = UseCaseInsertDishesToDb(dbRepositoryImpl)
    val useCaseGetAllDishesByFilters = UseCaseGetAllDishesByFilters(dbRepositoryImpl)
    val useCaseGetAllDishesFromApi = UseCaseGetAllDishesFromApi(apiRepositoryImpl)
    val useCaseGetAllDishesFromDb = UseCaseGetAllDishesFromDb(dbRepositoryImpl)

    private val _stateList = MutableLiveData<MainScreenState>()
    val stateList: LiveData<MainScreenState>
        get() = _stateList

    private val filtersList = mutableListOf<String>()
    fun addFilter(filters: String) {
        filtersList.add(filters)
        loadDataFromDbWithFilters()
    }

    fun removeFilter(filterName: String) {
        filtersList.remove(filterName)
        if (filtersList.size == 0) {
            loadDataFromDataBase()
        } else {
            loadDataFromDbWithFilters()
        }

    }

    private fun loadDataFromDbWithFilters() {
        useCaseGetAllDishesByFilters(filtersList)
            .onStart {
                _stateList.value = MainScreenState.Loading(true)
            }
            .onEach {
                _stateList.value = MainScreenState.Data(it.listOfDishesDomainToDishPL())
            }
            .catch {
                _stateList.value = MainScreenState.Error(it.message.toString())
            }
            .onCompletion {
                _stateList.value = MainScreenState.Loading(false)
            }
            .launchIn(viewModelScope)
    }

    fun loadDataFromApi() {
        useCaseGetAllDishesFromApi()
            .onStart {
                _stateList.value = MainScreenState.Loading(true)
            }
            .onEach {
                useCaseInsertDishesToDb(it.meals)
            }
            .catch {
                _stateList.value = MainScreenState.Error(it.message.toString())
            }
            .onCompletion {
                _stateList.value = MainScreenState.Loading(false)
            }
            .launchIn(viewModelScope)
    }

    fun loadDataFromDataBase() {
        useCaseGetAllDishesFromDb()
            .onStart {
                _stateList.value = MainScreenState.Loading(true)
            }
            .onEach {
                _stateList.value = MainScreenState.Data(it.listOfDishesDomainToDishPL())
            }
            .catch {
                _stateList.value = MainScreenState.Error(it.message.toString())
            }
            .onCompletion {
                _stateList.value = MainScreenState.Loading(false)
            }
            .launchIn(viewModelScope)
    }


}