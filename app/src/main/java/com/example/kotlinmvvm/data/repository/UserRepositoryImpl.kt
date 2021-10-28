package com.example.kotlinmvvm.data.repository

import com.example.kotlinmvvm.data.API
import com.example.kotlinmvvm.data.dto.UsersResponseDto
import com.example.kotlinmvvm.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: API
) : UserRepository {
    override suspend fun getUsers(): UsersResponseDto {
        return api.getUsers()
    }
}