package com.example.kotlinmvvm.presentation.users

import androidx.annotation.Nullable
import com.example.kotlinmvvm.domain.model.UserModel
import com.example.kotlinmvvm.domain.model.UserResponseModel

data class UsersListState(
    val isLoading: Boolean = false,
    val totalPages: Int = 0,
    val users : List<UserModel> = emptyList(),
    val error: String = "")
