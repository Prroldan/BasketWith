package com.basketwithapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.repository.FreeEventsRepository
import java.util.*


class FreeEventsViewModel: ViewModel() {

    private var freeEventsRepository = FreeEventsRepository()
    private lateinit var response: LiveData<List<ListFreeEventsResponseItem?>>
    private lateinit var response2: LiveData<List<ListFreeEventsResponseItem?>>
    var idFreeEventoSelecc: MutableLiveData<String> = MutableLiveData()

    fun allfreeEvents(): LiveData<List<ListFreeEventsResponseItem?>> {
        response = freeEventsRepository.getAllFreeEvents()
        return response
    }

    fun setIdFreeEventSeleccionado(idFreeEventoSeleccionado: String) {

        idFreeEventoSelecc.value = idFreeEventoSeleccionado
    }

    fun getIdFreeEventSeleccionado(): MutableLiveData<String> {
        return idFreeEventoSelecc
    }

    fun allfreeEventsMe(): LiveData<List<ListFreeEventsResponseItem?>> {
        response2 = freeEventsRepository.getAllEventsMe()
        return response2
    }


}