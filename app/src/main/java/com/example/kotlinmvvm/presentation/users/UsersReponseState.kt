package com.example.kotlinmvvm.presentation.users

import com.example.kotlinmvvm.domain.model.UserModel

data class UsersListState(
    val isLoading: Boolean = false,
    val totalPages: Int = 0,
    val users : List<UserModel> = emptyList(),
    val error: String = "")
