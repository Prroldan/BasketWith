package com.salesianostriana.BasketWith

import com.fasterxml.jackson.annotation.JsonFormat
import com.salesianostriana.BasketWith.users.User
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

data class EventoGratuitoDto(

        val id:UUID?,
        val nombre:String,
        val creado_por:User?,
        val ubicacion:String,
        val informacion:String,
        val ListPersonasUnidas: MutableList<User>? = mutableListOf(),
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        val horaEvento: LocalTime

        )

fun EventoGratuito.toEventoGratuitoDto() = EventoGratuitoDto (id, nombre, creadoPor, ubicacion, informacion, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)


data class NewEventoGratuitoDto(
        val nombre:String,
        val ubicacion: String,
        val informacion:String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:MM")
        val horaEvento: LocalTime
)

fun NewEventoGratuitoDto.toEventoGratuito(creado_por: User?) = EventoGratuito(nombre, creado_por, ubicacion, informacion,ArrayList(), LocalDate.now(),fechaEvento, horaEvento)

data class EventodePagoDto(

        val id:UUID?,
        val nombre:String,
        val creado_por:User?,
        val ubicacion:String,
        val informacion:String,
        val precioPorPersona: Double,
        val numContacto:String,
        val ListPersonasUnidas: MutableList<User>? = mutableListOf(),
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        val horaEvento: LocalTime

)

fun EventoDePago.toEventodePagoDto() = EventodePagoDto(id,nombre, creadoPor, ubicacion, informacion, precioPorPersona, numContacto, ListPersonasUnidasPago, fechaCreacion, fechaEvento, horaEvento)
fun EventodePagoDto.toEventoDePago() = EventoDePago(nombre, creado_por, ubicacion, informacion, precioPorPersona, numContacto, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)


data class NewEventoPagoDto(
        val nombre:String,
        val ubicacion: String,
        val informacion:String,
        val precioPorPersona: Double,
        val numContacto:String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:MM")
        val horaEvento: LocalTime
)

fun NewEventoPagoDto.toEventoPago(creado_por: User?) = EventoDePago(nombre, creado_por, ubicacion, informacion,precioPorPersona,numContacto,ArrayList(), LocalDate.now(),fechaEvento, horaEvento)
