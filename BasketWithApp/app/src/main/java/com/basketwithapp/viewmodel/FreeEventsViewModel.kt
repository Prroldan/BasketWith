package com.basketwithapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.dto.CreateFreeEventDto
import com.basketwithapp.dto.FreeEventoDto
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.repository.FreeEventsRepository
import java.util.*


class FreeEventsViewModel: ViewModel() {

    private var freeEventsRepository = FreeEventsRepository()
    private lateinit var response: LiveData<List<ListFreeEventsResponseItem?>>
    private lateinit var responseMe: MutableLiveData<List<ListFreeEventsResponseItem?>>
    var idFreeEventoSelecc: MutableLiveData<String> = MutableLiveData()
    var idEventoBorrar: MutableLiveData<String> = MutableLiveData()
    lateinit var createFreeEventDto:CreateFreeEventDto
    lateinit var freeEventDto: LiveData<FreeEventoDto>
    lateinit var freeEditEventDto: LiveData<FreeEventoDto>

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

    fun allfreeEventsMe(idUser:String): MutableLiveData<List<ListFreeEventsResponseItem?>> {
        responseMe= freeEventsRepository.getAllEventsMe(idUser)
        return responseMe
    }

    fun createFreeEvent(createFreeEventDto: CreateFreeEventDto): LiveData<FreeEventoDto>{
        freeEventDto = freeEventsRepository.createNewFreeEvent(createFreeEventDto)
        return freeEventDto

    }

    fun deleteFreeEvent(idEventoBorrar:String){
        freeEventsRepository.deleteFreeEvent(idEventoBorrar)
    }

    fun editFreeEvent(idEventoEditar:String, createFreeEventDto: CreateFreeEventDto):LiveData<FreeEventoDto>{
        freeEditEventDto=freeEventsRepository.editFreeEvent(idEventoEditar, createFreeEventDto)
        return freeEditEventDto

    }


}