package com.example.coockinglooping.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.coockinglooping.R
import com.example.coockinglooping.databinding.ActivityMainBinding
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModel
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    override fun onStart() {
        super.onStart()
        setUpMenu()
    }

    private fun setUpMenu(){
        val controller = findNavController(R.id.fragmentContainer)
        NavigationUI.setupWithNavController(binding.bottomNavigationMenu,controller)
    }
}