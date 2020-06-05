package com.basketwithapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.api.response.DetallePayEventResponse
import com.basketwithapp.repository.FreeEventsRepository
import com.basketwithapp.repository.PayEventsRepository
import java.util.*

class DetallePayEventViewModel: ViewModel() {

    lateinit var payEvent: MutableLiveData<DetallePayEventResponse?>
    var payEventRepository: PayEventsRepository = PayEventsRepository()

    fun getPayEvent(idEvent: String): MutableLiveData<DetallePayEventResponse?> {
        payEvent = payEventRepository.getOnePayEvent(idEvent)
        return payEvent

    }


}