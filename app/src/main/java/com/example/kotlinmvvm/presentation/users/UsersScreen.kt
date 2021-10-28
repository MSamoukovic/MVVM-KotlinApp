package com.example.kotlinmvvm.presentation.users

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kotlinmvvm.presentation.Screen
import com.example.kotlinmvvm.presentation.users.components.UserItem

@Composable
fun UsersScreen(
    navController: NavController,
    viewModel: UsersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.users) { user ->
                UserItem(
                    user = user,
                    onItemClick = {
                        navController.navigate(Screen.UserScreen.route + "/${user.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(text = state.error)
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}