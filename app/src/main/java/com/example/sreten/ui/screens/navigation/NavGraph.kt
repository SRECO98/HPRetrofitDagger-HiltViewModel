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
            //first compsoe that will be shown is HoemScreen()
            StartHomeScreen(navHostController = navHostController, homeViewModel = homeViewModel)
        }

        composable(
            route = Screen.CharacterScreen.route
        ){
            // he who called me (Main screen called after clicking image
            val character = navHostController.previousBackStackEntry?.savedStateHandle
                ?.get<com.example.sreten.data.api.model.Character>("character")
            character?.let { //if this person exist we will navigate to the detail screen.
                CharScreen(
                    navHostController = navHostController,
                    character = character
                )
            }

        }
    }
}