package com.example.sreten.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.sreten.data.api.model.Character
import com.example.sreten.ui.screens.navigation.Screen
import com.example.util.Resource

@Composable
fun StartHomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
    state: State<Resource<List<Character>>>
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .border(10.dp, color = Color(47, 110, 54))
            .padding(10.dp),
        backgroundColor = Color(11, 192, 29),
        topBar = {AppTopBarMainPage()}
    ){
        HomeScreen(navHostController, state)
    }
}

@Composable
fun HomeScreen(
    navController: NavHostController,
    state: State<Resource<List<Character>>>
) {

    when(state.value){
        is Resource.Error -> {
            //Error Message
        }

        is Resource.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        is Resource.Success -> {
            LazyColumn{
                if(state.value.data == null) return@LazyColumn
                items(state.value.data!!){ character: Character ->
                    CharacterImageCard(
                        character = character,
                        navController = navController,
                    )
                }
            }
        }
    }
}
@Composable
fun CharacterImageCard(
    character: Character,
    navController: NavHostController
) {

    //holding image
    val imagePainter = rememberImagePainter(data = character.image)
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp)
            .clickable {    //transport to second screen (second compose)
                navController.currentBackStackEntry?.savedStateHandle?.set("character", character)
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

@Composable
fun AppTopBarMainPage(){
    TopAppBar(
        backgroundColor = Color(47, 149, 57),
        title = {
            Text(
                text = "Harry Potter App",
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    )
}