package com.example.kotlinmvvm.domain.repository

import com.example.kotlinmvvm.data.dto.UsersResponseDto

interface UserRepository {
    suspend fun getUsers() : UsersResponseDto
}