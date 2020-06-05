package com.basketwithapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.dto.CreatePayEventDto
import com.basketwithapp.dto.PayEventDto
import com.basketwithapp.models.freeEvents.ListFreeEventsResponse
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.models.payEvents.ListPayEventsResponse
import com.basketwithapp.models.payEvents.ListPayEventsResponseItem
import com.basketwithapp.repository.FreeEventsRepository
import com.basketwithapp.repository.PayEventsRepository

class PayEventsViewModel: ViewModel() {

    private var payEventsRepository = PayEventsRepository()
    private lateinit var response: LiveData<List<ListPayEventsResponseItem?>>
    var idPayEventoSelecc: MutableLiveData<String> = MutableLiveData()
    var idEventoBorrar: MutableLiveData<String> = MutableLiveData()
    lateinit var payEventDto: LiveData<PayEventDto>
    lateinit var payEditEventDto: LiveData<PayEventDto>




    fun allpayEvents(): LiveData<List<ListPayEventsResponseItem?>> {
        response = payEventsRepository.getallPayEvents()
        return response
    }

    fun setIdPayEventSeleccionado(idPayEventoSeleccionado: String?) {

        idPayEventoSelecc.value = idPayEventoSeleccionado
    }

    fun getIdPayEventSeleccionado(): MutableLiveData<String> {
        return idPayEventoSelecc
    }

    fun allfreeEventsMe(idUser:String): LiveData<List<ListPayEventsResponseItem?>> {
        response = payEventsRepository.getallPayEventsMe(idUser)
        return response
    }

    fun createPayEvent(createPayEventDto: CreatePayEventDto): LiveData<PayEventDto>{
        payEventDto = payEventsRepository.createNewPayEvent(createPayEventDto)
        return payEventDto
    }

    fun deleteFreeEvent(idEventoBorrar:String){
        payEventsRepository.deletePayEvent(idEventoBorrar)
    }

    fun editFreeEvent(idEventoEditar:String, createPayEventDto: CreatePayEventDto):LiveData<PayEventDto>{
        payEditEventDto=payEventsRepository.editPayEvent(idEventoEditar, createPayEventDto)
        return payEditEventDto

    }
}
