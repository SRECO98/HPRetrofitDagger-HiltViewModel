package com.example.sreten.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sreten.ui.screens.StartCharScreen
import com.example.sreten.ui.screens.StartHomeScreen


@Composable
fun SetupNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ){

        composable(
            route = Screen.HomeScreen.route
        ){
            StartHomeScreen(navHostController = navHostController) //first compsoe that will be shown is HoemScreen()
        }

        composable(
            route = Screen.CharacterScreen.route
        ){
            StartCharScreen(navHostController) //first compsoe that will be shown is HoemScreen()
        }

    }
}