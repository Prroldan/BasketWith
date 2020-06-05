package com.basketwithapp.models.payEvents

data class ListPayEventsResponseItem(
    val ListPersonasUnidasPago: List<PersonasUnidasPago>,
    val creadoPor: CreadoPor,
    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val id: String,
    val informacion: String,
    val nombre: String,
    val numContacto: String,
    val precioPorPersona: Double,
    val ubicacion: String
)