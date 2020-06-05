package com.basketwithapp.models.freeEvents

import com.basketwithapp.models.User
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

data class EventoGratuito (

    val nombre: String,
    val creadoPor: User?,
    val ubicacion: String,
    val informacion: String,
    val ListPersonasUnidas: MutableList<User>?,
    val fechaCreacion: LocalDate,
    val fechaEvento: LocalDate,
    val horaEvento: LocalTime,
    val id: String? = null


)