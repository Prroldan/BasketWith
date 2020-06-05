package com.basketwithapp.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.api.BasketWithClient
import com.basketwithapp.api.BasketWithService
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.common.MyApp
import com.basketwithapp.models.freeEvents.ListFreeEventsResponse
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.models.payEvents.ListPayEventsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FreeEventsRepository {
    var basketWithService: BasketWithService
    var basketWithClient: BasketWithClient =
        BasketWithClient()
    var allfreeEvents: MutableLiveData<List<ListFreeEventsResponseItem?>> = MutableLiveData<List<ListFreeEventsResponseItem?>>()
    var allfreeEventsMe: MutableLiveData<List<ListFreeEventsResponseItem?>> = MutableLiveData<List<ListFreeEventsResponseItem?>>()
    var oneFreeEvent: MutableLiveData<DetalleFreeEventResponse> = MutableLiveData<DetalleFreeEventResponse>()



    init {
        basketWithService = basketWithClient.getBasketWithService()

    }

    fun getAllFreeEvents(): MutableLiveData<List<ListFreeEventsResponseItem?>> {
        val call: Call<List<ListFreeEventsResponseItem>> = basketWithService.getAllFreeEvents()
        call.enqueue(object: Callback<List<ListFreeEventsResponseItem>> {
            override fun onResponse(
                call: Call<List<ListFreeEventsResponseItem>>,
                response: Response<List<ListFreeEventsResponseItem>>
            ) {
                if(response.isSuccessful) {
                    allfreeEvents.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<ListFreeEventsResponseItem>>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allfreeEvents
    }

    fun getOneFreeEvent(idEvento:String): MutableLiveData<DetalleFreeEventResponse> {
        val call: Call<DetalleFreeEventResponse> = basketWithService.getFreeEventsById(idEvento)
        call.enqueue(object: Callback<DetalleFreeEventResponse> {
            override fun onResponse(
                call: Call<DetalleFreeEventResponse>,
                response: Response<DetalleFreeEventResponse>
            ) {
                if(response.isSuccessful) {
                    oneFreeEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<DetalleFreeEventResponse>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return oneFreeEvent
    }

    fun getAllEventsMe(): MutableLiveData<List<ListFreeEventsResponseItem?>> {
        val call: Call<List<ListFreeEventsResponseItem>> = basketWithService.getAllFreeEventsMe()
        call.enqueue(object: Callback<List<ListFreeEventsResponseItem>> {
            override fun onResponse(
                call: Call<List<ListFreeEventsResponseItem>>,
                response: Response<List<ListFreeEventsResponseItem>>
            ) {
                if(response.isSuccessful) {
                    allfreeEventsMe.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<ListFreeEventsResponseItem>>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allfreeEventsMe
    }

    fun createNewFreeEvent(){
        val call: Call<ListFreeEventsResponseItem> = basketWithService.createFreeEvent(createFreeEventDto:CreateFreeEventDto)
        call.enqueue(object: Callback<ListFreeEventsResponseItem> {
            override fun onResponse(
                call: Call<ListFreeEventsResponseItem>,
                response: Response<ListFreeEventsResponseItem>
            ) {
                if(response.isSuccessful) {
                    allpayEventsMe.value = response.body()
                }
            }

            override fun onFailure(call: Call<ListFreeEventsResponseItem>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allpayEventsMe
    }
}