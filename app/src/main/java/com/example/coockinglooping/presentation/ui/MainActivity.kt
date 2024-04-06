package com.example.coockinglooping.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.coockinglooping.R
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModel
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = MainScreenViewModelFactory(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MainScreenViewModel::class.java]
//        viewModel.loadDataFromApi()
//        viewModel.loadDataFromDataBase()
//        viewModel.addFilter("Dessert")
//        viewModel.stateList.observe(this) {
//            when (it) {
//                is MainScreenState.Loading -> {
//
//                }
//
//                is MainScreenState.Error -> {
////                    snackBarMessageShow("Ошибочка")
//                }
//
//                is MainScreenState.Data -> {
//                    Toast.makeText(this, it.data.toString(), Toast.LENGTH_LONG).show()
//                }
//            }
//        }


    }
}