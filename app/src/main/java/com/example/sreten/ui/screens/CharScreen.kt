package com.example.sreten.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.sreten.ui.screens.navigation.Screen

@Composable
fun CharScreen(
    navHostController: NavHostController,
    character: com.example.sreten.data.api.model.Character
) {

    Scaffold(
        backgroundColor = Color(11, 192, 29),
        modifier = Modifier
            .fillMaxSize()
            .border(10.dp, color = Color(47, 110, 54))
            .padding(10.dp),
        topBar = {
            ToppAppBarCompose(
                navHostController = navHostController,
                character.name
            )
        },
    ) {
        DetailScreenContent(character = character)
    }
}

@Composable
fun DetailScreenContent(character: com.example.sreten.data.api.model.Character){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 4.dp)
    ) {
        val image = rememberImagePainter(data = character.image)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(400.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(text = "Actor is: ${character.actor}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Date of birth is: ${character.dateOfBirth}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "House is: ${character.house}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Patronus of character: ${character.patronus}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Character species: ${character.species}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Character wizard: ${character.wizard}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Core of wand is: ${character.wand.core}\"", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Length of wand is: ${character.wand.length ?: "-"}", fontSize = 16.sp) //if == null print -
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Wand is built of: ${character.wand.wood}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }




}

@Composable
fun ToppAppBarCompose(navHostController: NavHostController, nameOfCharacter: String = "Default") {
    TopAppBar(
        backgroundColor = Color(47, 149, 57),
        title = {
            Text(
                text = nameOfCharacter,
                fontSize = 22.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis // putting ... if words cant fit in TopBar
            )
        },
        navigationIcon = {
            // return to first screen and deleting backstack so we cant back on second activity again with back button
            IconButton(onClick = {
                navHostController.navigate(Screen.HomeScreen.route) {
                    popUpTo(Screen.HomeScreen.route) {
                        inclusive = true
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
    )
}