package com.example.sreten.ui.screens.navigation

sealed class Screen (val route: String){
    object HomeScreen : Screen("home_screen")
    object CharacterScreen : Screen("characher_screen")
}