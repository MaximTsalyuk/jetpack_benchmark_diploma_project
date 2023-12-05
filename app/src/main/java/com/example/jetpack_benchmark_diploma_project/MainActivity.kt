package com.example.jetpack_benchmark_diploma_project

import HomeView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_benchmark_diploma_project.ui.theme.Jetpack_benchmark_diploma_projectTheme
import com.example.jetpack_benchmark_diploma_project.views.home.home_view_model

class MainActivity : ComponentActivity() {
    private val viewModel: home_view_model by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_benchmark_diploma_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView(viewModel = viewModel)
                }

//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "home") {
//                    composable(route = "home") {
//                        HomeView(viewModel = viewModel)
//                    }
//
//                    composable(route = "user") {
//                        UserView(user = )
//                    }
//                }

            }
        }
    }
}