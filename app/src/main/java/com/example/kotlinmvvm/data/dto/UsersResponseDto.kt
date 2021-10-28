package com.example.kotlinmvvm.data.dto


import android.net.wifi.p2p.WifiP2pManager
import android.util.Log
import com.example.kotlinmvvm.domain.model.UserModel
import com.example.kotlinmvvm.domain.model.UserResponseModel
import com.google.gson.annotations.SerializedName
import okhttp3.internal.assertThreadDoesntHoldLock

data class UsersResponseDto(
    @SerializedName("data")
    val `data`: List<UserDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

fun UsersResponseDto.toUserResponse() : UserResponseModel{
    return UserResponseModel(
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