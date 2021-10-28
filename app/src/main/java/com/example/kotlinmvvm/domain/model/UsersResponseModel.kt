package com.example.kotlinmvvm.domain.model

import androidx.lifecycle.MutableLiveData

data class UsersResponseModel(
    val data: List<UserModel>,
    val totalPages: Int
)
