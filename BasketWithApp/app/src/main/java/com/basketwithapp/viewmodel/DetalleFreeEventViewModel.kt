package com.basketwithapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.repository.FreeEventsRepository

class DetalleFreeEventViewModel: ViewModel() {
    lateinit var freeEvent: MutableLiveData<DetalleFreeEventResponse>
    var freeEventRepository: FreeEventsRepository = FreeEventsRepository()

    fun getFreeEvent(idEvent: String):MutableLiveData<DetalleFreeEventResponse>{
        freeEvent = freeEventRepository.getOneFreeEvent(idEvent)
        return freeEvent

    }
}