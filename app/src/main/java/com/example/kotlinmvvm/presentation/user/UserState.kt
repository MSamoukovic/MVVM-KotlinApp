package com.example.kotlinmvvm.presentation.user

import com.example.kotlinmvvm.domain.model.UserModel

data class UserState(
    val isLoading: Boolean = false,
    val user: UserModel? = null,
    val error: String = ""
)
