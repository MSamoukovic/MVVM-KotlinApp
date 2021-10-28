package com.example.kotlinmvvm.data.dto


import com.example.kotlinmvvm.domain.model.UserModel
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)

fun UserDto.toUser(): UserModel{
    return UserModel(
        email =  email,
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}