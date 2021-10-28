package com.example.kotlinmvvm.data

import com.example.kotlinmvvm.data.dto.ResponseDto
import com.example.kotlinmvvm.data.dto.UserDto
import com.example.kotlinmvvm.data.dto.UsersResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("users")
    suspend fun getUsers() : UsersResponseDto

    @GET("users/{userID}")
    suspend fun getUserById(
        @Path("userID") userID: Int
    ) : ResponseDto
}