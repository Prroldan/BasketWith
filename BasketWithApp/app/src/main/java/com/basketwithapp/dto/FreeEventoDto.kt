package com.basketwithapp.dto

import com.basketwithapp.models.User

data class FreeEventoDto(
    val creado_por: User,
    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val id: String,
    val informacion: String,
    val listPersonasUnidas: List<Any>,
    val nombre: String,
    val ubicacion: String
)