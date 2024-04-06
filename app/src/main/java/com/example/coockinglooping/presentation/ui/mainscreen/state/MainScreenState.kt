package com.example.coockinglooping.presentation.ui.mainscreen.state

sealed class MainScreenState {
    data class Loading(val boolean: Boolean) : MainScreenState()

    data class Data(val data: Any) : MainScreenState()

    data class Error(val errorMessage: String) : MainScreenState()

}