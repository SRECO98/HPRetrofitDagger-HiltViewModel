package com.example.sreten.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.sreten.data.api.model.Character
import com.example.sreten.ui.screens.navigation.Screen

@Composable
fun StartHomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
){

    val state by homeViewModel.state.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        HomeScreen(navHostController, state)
    }
}

@Composable
fun HomeScreen(navController: NavHostController, state: List<Character>) {


    LazyColumn() {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) { character: Character ->
            CharacterImageCard(
                character = character,
                navController = navController
            )
        }
    }
}

@Composable
fun CharacterImageCard(
    character: Character,
    navController: NavHostController
) {
    val imagePainter = rememberImagePainter(data = character.image)

    //holding image
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp)
            .clickable {    //transport to second screen (second compose)
                navController.navigate(route = Screen.CharacterScreen.route)
            }
    ) {
        Box {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            
            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Text(text = "Real name: ${character.actor}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Movie name: ${character.name}")
                }
            }
        }
    }
}