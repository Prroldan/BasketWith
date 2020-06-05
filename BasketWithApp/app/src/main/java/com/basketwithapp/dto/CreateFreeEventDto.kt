package com.basketwithapp.dto

data class CreateFreeEventDto(
    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val informacion: String,
    val nombre: String,
    val ubicacion: String
)