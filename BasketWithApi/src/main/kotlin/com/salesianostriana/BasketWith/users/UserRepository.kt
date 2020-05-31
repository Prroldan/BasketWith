package com.salesianostriana.BasketWith.users

import com.salesianostriana.BasketWith.users.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {

    fun findByUsername(username : String) : Optional<User>

}