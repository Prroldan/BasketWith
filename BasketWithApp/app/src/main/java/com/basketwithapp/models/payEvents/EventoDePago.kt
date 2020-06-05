package com.basketwithapp.models.payEvents

import com.basketwithapp.models.User
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

data class EventoDePago (
    var nombre: String,
    var creadoPor: User?,
    var ubicacion: String,
    var informacion: String,
    var precioPorPersona: Double,
    var numContacto: String,
    var ListPersonasUnidasPago: MutableList<User>? = null,
    var fechaCreacion: LocalDate,
    var fechaEvento: LocalDate,
    var horaEvento: LocalTime,
    val id: String? = null
)