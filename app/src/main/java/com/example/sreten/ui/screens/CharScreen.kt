package com.example.sreten.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sreten.ui.screens.navigation.Screen

@Composable
fun CharScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = { ToppAppBarCompose(navHostController = navHostController) }
    ) {
        Text(
            text = "Second Screen Test",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ToppAppBarCompose(navHostController: NavHostController){
    TopAppBar (
        title = {
            Text(
                text = "Karakter",
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis // putting ... if words cant fit in TopBar
            )
        },
        navigationIcon = {
            // return to first screen and deleting backstack so we cant back on second activity again with back button
            IconButton(onClick = {
                navHostController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.HomeScreen.route){
                        inclusive = true
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        )
}