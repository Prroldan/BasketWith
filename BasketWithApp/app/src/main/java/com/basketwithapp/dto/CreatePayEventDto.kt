package com.basketwithapp.dto

data class CreatePayEventDto (

    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val informacion: String,
    val nombre: String,
    val ubicacion: String,
    val precioPorPersona:String,
    val numContacto:String
)