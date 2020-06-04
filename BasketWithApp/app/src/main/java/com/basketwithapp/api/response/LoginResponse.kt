package com.basketwithapp.api.response

import com.basketwithapp.models.User

data class LoginResponse(
    val token: String,
    val user: User
)