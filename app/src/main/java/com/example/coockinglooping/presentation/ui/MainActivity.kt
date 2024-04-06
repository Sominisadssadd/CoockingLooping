package com.example.coockinglooping.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.coockinglooping.R
import com.example.coockinglooping.data.repository.ApiRepositoryImpl
import com.example.coockinglooping.data.repository.DbRepositoryImpl
import com.example.coockinglooping.domain.model.Dish
import com.example.coockinglooping.domain.usecase.UseCaseGetAllDishesFromApi
import com.example.coockinglooping.domain.usecase.UseCaseInsertDishesToDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}