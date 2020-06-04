package com.basketwithapp.dto

data class RegistroDto(
    val edad: String,
    val name: String,
    val password: String,
    val surname: String,
    val username: String,
    val dni:String,
    val eventosCreados:Int = 0,
    val eventosParticipados:Int = 0
)