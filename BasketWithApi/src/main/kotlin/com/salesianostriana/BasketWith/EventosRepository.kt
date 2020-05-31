package com.salesianostriana.BasketWith

import com.salesianostriana.BasketWith.users.User
import com.salesianostriana.BasketWith.users.UserRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import javax.annotation.PostConstruct
import kotlin.collections.ArrayList
interface EventoGratuitoRepository:JpaRepository<EventoGratuito, UUID>{



    fun findByNombre(nombre:String):Optional<EventoGratuito>
    fun findByCreadoPor(creado_por:String):Optional<EventoGratuito>


}
interface EventoPagoRepository:JpaRepository<EventoDePago,UUID>{

    fun findByNombre(nombre:String):Optional<EventoDePago>
    fun findByCreadoPor(creado_por: String):Optional<EventoDePago>

}

@Component
class InitDataComponent(

        val eventosGratuitosRepository: EventoGratuitoRepository,
        val eventosRepository: EventoPagoRepository,
        val userRepository: UserRepository,
        val encodedPassword: BCryptPasswordEncoder

)
{ @PostConstruct
fun initData(){


    val user1 = User("Usuario", encodedPassword.encode("1234"), "Usuario 1","user 1",2,"dni1",2,3,"USER")
    val user2 = User("Usuario2", encodedPassword.encode("1234"), "Usuario 2","user 2",2,"dni2",3,4,"USER")
    val user3 = User("Usuario3", encodedPassword.encode("1234"), "Usuario 3","user 3",2,"dni3",4,5,"USER")
    val user4 = User("Usuario4", encodedPassword.encode("1234"), "Usuario 4","user 4",2,"dni4",6,7,"USER")

    userRepository.save(user1)
    userRepository.save(user2)
    userRepository.save(user3)
    userRepository.save(user4)
    println(user4.id)
    println(user1.id)

    val listaUsuarios = ArrayList<User>()
    val listaUsuariosVacia = ArrayList<User>()
    listaUsuarios.addAll(listOf(user2,user3))

    val event1 = EventoGratuito("Evento 1", user1, "Calle totus", "evento gratuito de basket",  listaUsuarios, LocalDate.now(), LocalDate.now(), LocalTime.now())
    val event2 = EventoGratuito("Evento 2", user2, "Calle totus 2", "evento gratuito de basket 2",  listaUsuarios, LocalDate.now(), LocalDate.now(), LocalTime.now())
    val event3 = EventoGratuito("Evento 3", user3, "Calle totus 3", "evento gratuito de basket 3",  listaUsuarios, LocalDate.now(), LocalDate.now(), LocalTime.now())
    val event4 = EventoDePago("Evento 3", user4, "Calle totus 3", "evento gratuito de basket 3", 2.2,"666666", listaUsuarios, LocalDate.now(), LocalDate.now(), LocalTime.now())
    val event5 = EventoDePago("Evento 3", user4, "Calle totus 3", "evento gratuito de basket 3", 2.3,"666666", listaUsuarios, LocalDate.now(), LocalDate.now(), LocalTime.now())
    val event6 = EventoDePago("Evento 3", user1, "Calle totus 3", "evento gratuito de basket 3", 2.4,"666666", listaUsuariosVacia, LocalDate.now(), LocalDate.now(), LocalTime.now())



    eventosRepository.save(event5)
    eventosGratuitosRepository.save(event1)

    userRepository.save(user1)
    userRepository.save(user2)
    userRepository.save(user3)
    userRepository.save(user4)

    //eventosGratuitosRepository.save(event2)
    //eventosGratuitosRepository.save(event3)
    //eventosRepository.save(event4)


}

}