package com.salesianostriana.BasketWith.users

import com.salesianostriana.BasketWith.users.User
import java.util.*

data class UserDTO(
        var username : String,
        var name: String,
        var surname:String,
        var dni:String,
        var edad:Number,
        var eventosCreados: Number,
        var eventosParticipados: Number,
        var roles: String,
        val id: UUID? = null
)

fun User.toUserDTO() = UserDTO(username, name, surname, dni, edad,eventosCreados, eventosParticipados , roles.joinToString(), id)


data class CreateUserDTO(
        var username: String,
        var name: String,
        var surname: String,
        var dni:String,
        var edad:Number,
        val password: String

)


