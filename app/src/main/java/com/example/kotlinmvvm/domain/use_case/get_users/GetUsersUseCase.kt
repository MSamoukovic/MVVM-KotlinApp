package com.example.kotlinmvvm.domain.use_case.get_users

import com.example.kotlinmvvm.common.Resource
import com.example.kotlinmvvm.data.dto.toUserResponse
import com.example.kotlinmvvm.domain.model.UserResponseModel
import com.example.kotlinmvvm.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Resource<UserResponseModel>> = flow {
        try {
            emit(Resource.Loading<UserResponseModel>())
            val usersResponse = repository.getUsers().toUserResponse()
            emit(Resource.Success<UserResponseModel>(usersResponse))
        }
        catch(e: HttpException) {
            emit(Resource.Error<UserResponseModel>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<UserResponseModel>("Couldn't reach server. Check your internet connection."))
        }
    }
}