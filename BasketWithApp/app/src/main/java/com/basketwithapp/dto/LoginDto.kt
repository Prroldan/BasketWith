package com.basketwithapp.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("username")
    @Expose
    var username: String,

    @SerializedName("password")
    @Expose
    val password: String
)