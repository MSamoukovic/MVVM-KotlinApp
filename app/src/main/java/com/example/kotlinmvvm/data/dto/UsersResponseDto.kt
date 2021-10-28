package com.example.kotlinmvvm.data.dto


import com.example.kotlinmvvm.domain.model.UserModel
import com.example.kotlinmvvm.domain.model.UsersResponseModel
import com.google.gson.annotations.SerializedName

data class UsersResponseDto(
    @SerializedName("data")
    val `data`: List<UserDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val supportDto: SupportDto,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

fun UsersResponseDto.toUserResponse() : UsersResponseModel{
    return UsersResponseModel(
        data = convertDtoToModel(data),
        totalPages = totalPages
    )
}

fun convertDtoToModel(data: List<UserDto>) :List<UserModel>{
    var list = mutableListOf<UserModel>()

    data.forEachIndexed { index, element ->
        list.add(element.toUser())
    }
    return list;
}