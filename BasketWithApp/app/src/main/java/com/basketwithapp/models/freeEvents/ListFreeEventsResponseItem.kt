package com.basketwithapp.models.freeEvents

data class ListFreeEventsResponseItem(
    val ListPersonasUnidas: List<PersonasUnidas>,
    val creadoPor: CreadoPor,
    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val id: String,
    val informacion: String,
    val nombre: String,
    val ubicacion: String
)