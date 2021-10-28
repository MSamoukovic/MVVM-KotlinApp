package com.example.kotlinmvvm.domain.model

import androidx.lifecycle.MutableLiveData

data class UserResponseModel(
    val data: List<UserModel>,
    val totalPages: Int
)
