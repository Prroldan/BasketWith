package com.salesianostriana.BasketWith

import com.salesianostriana.BasketWith.users.User
import com.salesianostriana.BasketWith.users.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class EventFreeService: BaseService<EventoGratuito, UUID, EventoGratuitoRepository>(){
    fun findByIdFree(id : UUID): Optional<EventoGratuito> {
        return this.repository.findById(id)
    }
    fun findByNombreFree(nombre:String): Optional<EventoGratuito> {
        return this.repository.findByNombre(nombre)

    }
    fun findByCreadoPorFree(id:UUID): List<EventoGratuito> {
        return this.repository.findAllHistorial(id)
    }


}

@Service
class EventPayService: BaseService<EventoDePago, UUID, EventoPagoRepository>() {

    fun findByIdPay(id : UUID): Optional<EventoDePago> {
        return this.repository.findById(id)
    }
    fun findByNombrePay(nombre:String): Optional<EventoDePago> {
        return this.repository.findByNombre(nombre)
    }

    fun findByCreadoPorPay(creadoPor: User): List<EventoDePago> {
        return this.repository.findAllByCreadoPor(creadoPor)
    }

}