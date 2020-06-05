package com.basketwithapp.models.payEvents

import com.basketwithapp.models.payEvents.Authority

data class PersonasUnidasPago(
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val authorities: List<Authority>,
    val credentialsNonExpired: Boolean,
    val dni: String,
    val edad: Int,
    val enabled: Boolean,
    val eventosCreados: Int,
    val eventosParticipados: Int,
    val id: String,
    val name: String,
    val password: String,
    val roles: List<String>,
    val surname: String,
    val username: String
)