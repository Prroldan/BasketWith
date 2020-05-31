package com.salesianostriana.BasketWith

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.salesianostriana.BasketWith.users.User
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import java.util.concurrent.TimeUnit
import javax.persistence.*

@Entity
data class EventoGratuito(

        var nombre: String,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")
        var creadoPor: User?,
        var ubicacion: String,
        var informacion: String,
        @JsonManagedReference
        @ManyToMany(fetch = FetchType.EAGER)
        var ListPersonasUnidas: MutableList<User>?,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        var fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        var fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        var horaEvento: LocalTime,

        @Id
        @GeneratedValue
        val id: UUID? = null


)

@Entity
data class EventoDePago(

        var nombre: String,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "usuario_id_pago", referencedColumnName = "id")
        var creadoPor: User?,
        var ubicacion: String,
        var informacion: String,
        var precioPorPersona: Double,
        var numContacto: String,
        @JsonManagedReference
        @ManyToMany(fetch = FetchType.EAGER)
        var ListPersonasUnidasPago: MutableList<User>? = null,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        var fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        var fechaEvento: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:SS")
        var horaEvento: LocalTime,

        @Id
        @GeneratedValue
        val id: UUID? = null


)