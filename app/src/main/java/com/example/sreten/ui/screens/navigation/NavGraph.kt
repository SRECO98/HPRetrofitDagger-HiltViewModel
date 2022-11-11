package com.example.sreten.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sreten.ui.screens.CharScreen
import com.example.sreten.ui.screens.HomeViewModel
import com.example.sreten.ui.screens.StartHomeScreen


@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ){

        composable(
            route = Screen.HomeScreen.route
        ){
            StartHomeScreen(navHostController = navHostController, homeViewModel = homeViewModel) //first compsoe that will be shown is HoemScreen()
        }

        composable(
            route = Screen.CharacterScreen.route
        ){
            CharScreen(navHostController = navHostController) //first compsoe that will be shown is HoemScreen()
        }

    }
}