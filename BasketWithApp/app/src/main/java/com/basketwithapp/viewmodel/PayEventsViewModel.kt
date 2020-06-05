package com.basketwithapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun allfreeEventsMe(): LiveData<List<ListPayEventsResponseItem?>> {
        response = payEventsRepository.getallPayEventsMe()
        return response
    }
}
