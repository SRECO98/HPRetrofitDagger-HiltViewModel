package com.example.sreten

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sreten.data.api.ApiConstants
import com.example.sreten.ui.screens.HomeViewModel
import com.example.sreten.ui.screens.navigation.SetupNavGraph
import com.example.sreten.ui.theme.SretenTheme
import com.example.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SretenTheme {
                gettingState()
            }
        }
    }

    @Composable
    fun gettingState(){
        navHostController = rememberNavController()
        val state = viewModel.characters.collectAsState(Resource.Loading())
        SetupNavGraph(navHostController = navHostController, homeViewModel = viewModel, state = state)
    }
}