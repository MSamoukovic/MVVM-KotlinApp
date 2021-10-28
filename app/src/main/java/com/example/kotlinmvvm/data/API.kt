package com.example.kotlinmvvm.data

import com.example.kotlinmvvm.data.dto.UsersResponseDto
import retrofit2.http.GET

interface API {

    @GET("users")
    suspend fun getUsers() : UsersResponseDto
}