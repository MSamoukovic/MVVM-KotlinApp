package com.example.kotlinmvvm.presentation.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)

    ) {
        Image(
            painter = rememberImagePainter(state.user?.avatar),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.White, CircleShape)
                .clip(CircleShape)
        )
    }
}