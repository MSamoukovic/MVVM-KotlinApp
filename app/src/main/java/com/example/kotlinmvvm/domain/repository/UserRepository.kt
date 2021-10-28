package com.example.kotlinmvvm.domain.repository

import com.example.kotlinmvvm.data.dto.ResponseDto
import com.example.kotlinmvvm.data.dto.UserDto
import com.example.kotlinmvvm.data.dto.UsersResponseDto

interface UserRepository {
    suspend fun getUsers() : UsersResponseDto
    suspend fun getUserById(userID: Int) : ResponseDto
}