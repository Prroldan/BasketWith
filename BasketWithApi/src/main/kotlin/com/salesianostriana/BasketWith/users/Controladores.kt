package com.salesianostriana.BasketWith.users

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("events/")
class NotasController(
        val userRepository: UserRepository
){


}