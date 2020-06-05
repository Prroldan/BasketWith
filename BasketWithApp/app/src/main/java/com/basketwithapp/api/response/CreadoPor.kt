package com.basketwithapp.api.response

data class CreadoPor(
    val dni: String,
    val edad: Int,
    val enabled: Boolean,
    val eventosCreados: Int,
    val eventosParticipados: Int,
    val id: String,
    val name: String,
    val password: String,
    val roles: List<String>,
    val surname: String,
    val username: String
)