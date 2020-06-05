package com.salesianostriana.BasketWith

import com.salesianostriana.BasketWith.users.User
import com.salesianostriana.BasketWith.users.UserRepository
import com.salesianostriana.BasketWith.users.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/freeEvents")
class EventoGratuitoController(val eventFreeService: EventFreeService, val userService: UserService) {


    private fun getFreeEventsById(id: UUID): EventoGratuito {
        var result: Optional<EventoGratuito>
        with(eventFreeService) {
            result = findByIdFree(id)
        }
        return result.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el evento con el id:  ${id}") }


    }

    @GetMapping("/")
    private fun getAllFreeEvents(): List<EventoGratuito> {
        var result: List<EventoGratuito>
        with(eventFreeService) {
            result = findAll()
        }

        if (result.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha creado ningún evento ")

        return result
    }


    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID) = getFreeEventsById(id).toEventoGratuitoDto()

    @PostMapping("/")
    fun newFreeEvent(@RequestBody newFreeEvent: NewEventoGratuitoDto, @AuthenticationPrincipal user:User): ResponseEntity<EventoGratuitoDto> = ResponseEntity.status(HttpStatus.CREATED)
            .body(eventFreeService.save(newFreeEvent.toEventoGratuito(user)).toEventoGratuitoDto())

    @PostMapping("/{idUser}/{idEvento}")
    fun joinFreeEvent(@PathVariable idUser: UUID, @PathVariable idEvento: UUID) {
        var user: User? = null
        var eventoGratuito: EventoGratuito? = null
        user = userService.findById(idUser).get()
        eventoGratuito = eventFreeService.findByIdFree(idEvento).get()
        if (user != null) {
            eventoGratuito?.creadoPor = user
            eventoGratuito?.ListPersonasUnidas?.add(user)
            eventFreeService.save(eventoGratuito)
        }

    }

    @PutMapping("/")
    fun editFreeEvent(idEdit: UUID, @RequestBody edit: NewEventoGratuitoDto): EventoGratuitoDto {
        var result = getFreeEventsById(idEdit)
        result.nombre = edit.nombre
        result.horaEvento = edit.horaEvento
        result.informacion = edit.informacion
        result.ubicacion = edit.ubicacion
        result.fechaEvento = edit.fechaEvento
        ResponseEntity.status(HttpStatus.CREATED)
                .body(eventFreeService.save(result))


        return result.toEventoGratuitoDto()
    }

    @DeleteMapping("/{idUser}/{idEvento}")
    fun exitFreeEvent(@PathVariable idUser: UUID, @PathVariable idEvento: UUID) {
        var user: User? = null
        var eventoGratuito: EventoGratuito? = null
        user = userService.findById(idUser).get()
        eventoGratuito = eventFreeService.findByIdFree(idEvento).get()
        if (user != null) {
            eventoGratuito?.ListPersonasUnidas?.remove(user)
            eventFreeService.save(eventoGratuito)
        }

    }

    @DeleteMapping("/{id}")
    fun delFreeEvent(@PathVariable id: UUID) {
        var result: EventoGratuito
        result = getFreeEventsById(id)

        eventFreeService.delete(result)
    }

    @GetMapping("/me/{id}")
    fun getAllFreeEventsMe(@PathVariable id:UUID): List<EventoGratuito> {
        var result: List<EventoGratuito>
        with(eventFreeService) {
            result = findByCreadoPorFree(id)
        }

        if (result.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha creado ningún evento ")

        return result
    }
}





@RestController
@RequestMapping("/payEvents")
class EventoDePagoController(val eventPayService: EventPayService, val userService: UserService) {


    private fun getPayEventsById(id: UUID): EventoDePago {
        var result: Optional<EventoDePago>
        with(eventPayService) {
            result = findByIdPay(id)
        }
        return result.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ningún evento con el id:  ${id}") }


    }

    @GetMapping("/")
    private fun getAllPayEvents(): List<EventoDePago> {
        var result: List<EventoDePago>
        with(eventPayService) {
            result = findAll()
        }

        if (result.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha creado ningún evento ")

        return result
    }


    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID) = getPayEventsById(id).toEventodePagoDto()

    @PostMapping("/")
    fun newPayEvent(@RequestBody newPayEvent: NewEventoPagoDto, @AuthenticationPrincipal user:User): ResponseEntity<EventodePagoDto> = ResponseEntity.status(HttpStatus.CREATED)
            .body(eventPayService.save(newPayEvent.toEventoPago(user)).toEventodePagoDto())

    @PostMapping("/{idEvento}")
    fun joinPayEvent(@AuthenticationPrincipal user:User, @PathVariable idEvento: UUID) {

        var eventoDePago: EventoDePago? = null
        eventoDePago = eventPayService.findByIdPay(idEvento).get()
        if (user != null) {
            eventoDePago?.ListPersonasUnidasPago?.add(user)
            eventPayService.save(eventoDePago)
        }

    }

    @PutMapping("/")
    fun editPayEvent(idEdit: UUID, @RequestBody edit: EventodePagoDto): EventodePagoDto {
        var result = getPayEventsById(idEdit)
        result.nombre = edit.nombre
        result.horaEvento = edit.horaEvento
        result.informacion = edit.informacion
        result.ubicacion = edit.ubicacion
        result.fechaEvento = edit.fechaEvento
        ResponseEntity.status(HttpStatus.CREATED)
                .body(eventPayService.save(result))


        return result.toEventodePagoDto()
    }

    @DeleteMapping("/{idUser}/{idEvento}")
    fun exitPayEvent(@PathVariable idUser: UUID, @PathVariable idEvento: UUID) {
        var user: User? = null
        var eventoDePago: EventoDePago? = null
        user = userService.findById(idUser).get()
        eventoDePago = eventPayService.findByIdPay(idEvento).get()
        if (user != null) {
            eventoDePago?.ListPersonasUnidasPago?.remove(user)
            eventPayService.save(eventoDePago)
        }

    }

    @DeleteMapping("/")
    fun delPayEvents(id: UUID) {
        var result: EventoDePago
        result = getPayEventsById(id)

        eventPayService.delete(result)
    }

}