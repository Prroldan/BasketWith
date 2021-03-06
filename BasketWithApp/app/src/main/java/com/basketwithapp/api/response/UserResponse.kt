package com.basketwithapp.api.response

data class UserResponse(
    val dni: String,
    val edad: Int,
    val eventosCreados: Int,
    val eventosParticipados: Int,
    val id: String,
    val name: String,
    val roles: String,
    val surname: String,
    val username: String
)