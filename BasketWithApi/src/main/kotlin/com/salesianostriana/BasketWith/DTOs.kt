package com.salesianostriana.BasketWith

import com.fasterxml.jackson.annotation.JsonFormat
import com.salesianostriana.BasketWith.users.User
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

data class eventoGratuitoDto(

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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        val horaEvento: LocalTime

        )

fun EventoGratuito.toEventoGratuitoDto() = eventoGratuitoDto (id, nombre, creadoPor, ubicacion, informacion, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)
fun eventoGratuitoDto.toEventoGratuito() = EventoGratuito(nombre, creado_por, ubicacion, informacion, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)

data class CreateeventoGratuitoDto(

        val id:UUID,
        val nombre:String,
        val creado_por:User?,
        val ubicacion:String,
        val informacion:String,
        val ListPersonasUnidas: MutableList<User>? = mutableListOf(),
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        val horaEvento: LocalTime

)

fun CreateeventoGratuitoDto.toEventoGratuito() = EventoGratuito(nombre, creado_por, ubicacion, informacion, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)

data class eventodePagoDto(

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

fun EventoDePago.toEventodePagoDto() = eventodePagoDto(id,nombre, creadoPor, ubicacion, informacion, precioPorPersona, numContacto, ListPersonasUnidasPago, fechaCreacion, fechaEvento, horaEvento)
fun eventodePagoDto.toEventoDePago() = EventoDePago(nombre, creado_por, ubicacion, informacion, precioPorPersona, numContacto, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)


data class CreateeventodePagoDto(

        val id:UUID,
        val nombre:String,
        val creado_por:User?,
        val ubicacion:String,
        val informacion:String,
        val precioPorPersona: Double,
        val numContacto:String,
        val ListPersonasUnidas: MutableList<User>,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        val horaEvento: LocalTime

)

fun CreateeventodePagoDto.toEventoDePAgo() = EventoDePago(nombre, creado_por, ubicacion, informacion, precioPorPersona, numContacto, ListPersonasUnidas, fechaCreacion, fechaEvento, horaEvento)
