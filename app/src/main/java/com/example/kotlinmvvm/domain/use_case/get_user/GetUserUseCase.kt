package com.example.kotlinmvvm.domain.use_case.get_user

import com.example.kotlinmvvm.common.Resource
import com.example.kotlinmvvm.data.dto.toResponse
import com.example.kotlinmvvm.data.dto.toUser
import com.example.kotlinmvvm.domain.model.UserModel
import com.example.kotlinmvvm.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(userID: Int): Flow<Resource<UserModel>> = flow {
        try {
            emit(Resource.Loading<UserModel>())
            val user = repository.getUserById(userID).toResponse()
            emit(Resource.Success<UserModel>(user))
        }
        catch(e: HttpException) {
            emit(Resource.Error<UserModel>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<UserModel>("Couldn't reach server. Check your internet connection."))
        }
    }
}