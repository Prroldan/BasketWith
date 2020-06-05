package com.basketwithapp.api.response

data class DetalleFreeEventResponse (
    val creado_por: CreadoPor,
    val fechaCreacion: String,
    val fechaEvento: String,
    val horaEvento: String,
    val id: String,
    val informacion: String,
    val listPersonasUnidas: List<PersonasUnidas>,
    val nombre: String,
    val ubicacion: String
)
