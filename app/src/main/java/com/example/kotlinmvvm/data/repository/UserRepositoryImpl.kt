package com.example.kotlinmvvm.data.repository

import com.example.kotlinmvvm.data.API
import com.example.kotlinmvvm.data.dto.ResponseDto
import com.example.kotlinmvvm.data.dto.UserDto
import com.example.kotlinmvvm.data.dto.UsersResponseDto
import com.example.kotlinmvvm.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: API
) : UserRepository {
    override suspend fun getUsers(): UsersResponseDto {
        return api.getUsers()
    }

    override suspend fun getUserById(userID: Int) : ResponseDto{
        return api.getUserById(userID)
    }
}