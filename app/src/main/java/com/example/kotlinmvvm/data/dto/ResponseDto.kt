package com.example.kotlinmvvm.data.dto


import com.example.kotlinmvvm.domain.model.UserModel
import com.example.kotlinmvvm.domain.model.UserResponseModel
import com.example.kotlinmvvm.domain.model.UsersResponseModel
import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("data")
    val `data`: UserDto,
    @SerializedName("support")
    val supportDto: SupportDto
)

fun ResponseDto.toResponse() : UserModel {
    return UserModel(
        email = data.toUser().email,
        firstName = data.toUser().firstName,
        lastName = data.toUser().lastName,
        avatar = data.toUser().avatar,
        id = data.toUser().id
    )
}