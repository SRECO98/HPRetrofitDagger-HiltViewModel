package com.example.sreten.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.sreten.ui.screens.navigation.Screen

@Composable
fun StartCharScreen(
    navHostController: NavHostController
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        CharScreen(navHostController = navHostController)
    }
}

@Composable
fun CharScreen(navHostController: NavHostController) {

    Scaffold() {
        Text(
            text = "Second Screen Test",
            modifier = Modifier
                .fillMaxSize()
                .clickable {
// return to first screen and deleting backstack so we cant back on second activity again with back button
                    navHostController.navigate(Screen.HomeScreen.route){
                        popUpTo(Screen.HomeScreen.route){
                            inclusive = true
                        }
                    }
                }
        )
    }
}
