package com.example.kotlinmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinmvvm.presentation.Screen
import com.example.kotlinmvvm.presentation.user.UserScreen
import com.example.kotlinmvvm.presentation.users.UsersScreen

import com.example.kotlinmvvm.ui.theme.KotlinMVVMTheme
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.UsersListScreen.route
                    ){
                        composable(
                            route = Screen.UsersListScreen.route
                        ){
                            UsersScreen(navController)
                        }
                        composable(
                            route = Screen.UserScreen.route + "/{userID}"
                        ){
                            UserScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinMVVMTheme {
        Greeting("Android")
    }
}