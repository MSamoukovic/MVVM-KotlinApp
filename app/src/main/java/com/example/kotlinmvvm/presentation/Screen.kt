package com.example.kotlinmvvm.presentation

sealed class Screen(val route: String) {
    object UsersListScreen: Screen("users_list")
    object UserScreen: Screen("user")
}
