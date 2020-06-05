package com.basketwithapp.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.api.BasketWithClient
import com.basketwithapp.api.BasketWithService
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.api.response.DetallePayEventResponse
import com.basketwithapp.common.MyApp
import com.basketwithapp.models.payEvents.ListPayEventsResponse
import com.basketwithapp.models.payEvents.ListPayEventsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PayEventsRepository {
    var basketWithService: BasketWithService
    var basketWithClient: BasketWithClient =
        BasketWithClient()
    var allpayEvents: MutableLiveData<List<ListPayEventsResponseItem?>> = MutableLiveData<List<ListPayEventsResponseItem?>>()
    var allpayEventsMe: MutableLiveData<List<ListPayEventsResponseItem?>> = MutableLiveData<List<ListPayEventsResponseItem?>>()
    var onePayEvent: MutableLiveData<DetallePayEventResponse?> = MutableLiveData<DetallePayEventResponse?>()



    init {
        basketWithService = basketWithClient.getBasketWithService()

    }

    fun getallPayEvents(): MutableLiveData<List<ListPayEventsResponseItem?>> {
        val call: Call<List<ListPayEventsResponseItem>> = basketWithService.getAllPayEvents()
        call.enqueue(object: Callback<List<ListPayEventsResponseItem>> {
            override fun onResponse(
                call: Call<List<ListPayEventsResponseItem>>,
                response: Response<List<ListPayEventsResponseItem>>
            ) {
                if(response.isSuccessful) {
                    allpayEvents.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<ListPayEventsResponseItem>>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allpayEvents
    }

    fun getOnePayEvent(idEvento: String): MutableLiveData<DetallePayEventResponse?> {
        val call: Call<DetallePayEventResponse> = basketWithService.getPayEventsById(idEvento)
        call.enqueue(object: Callback<DetallePayEventResponse> {
            override fun onResponse(
                call: Call<DetallePayEventResponse>,
                response: Response<DetallePayEventResponse>
            ) {
                if(response.isSuccessful) {
                    onePayEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<DetallePayEventResponse>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return onePayEvent
    }

    fun getallPayEventsMe(): MutableLiveData<List<ListPayEventsResponseItem?>> {
        val call: Call<List<ListPayEventsResponseItem>> = basketWithService.getAllPayEventsMe()
        call.enqueue(object: Callback<List<ListPayEventsResponseItem>> {
            override fun onResponse(
                call: Call<List<ListPayEventsResponseItem>>,
                response: Response<List<ListPayEventsResponseItem>>
            ) {
                if(response.isSuccessful) {
                    allpayEventsMe.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<ListPayEventsResponseItem>>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allpayEventsMe
    }

    fun createNewPayEvent(){
        val call: Call<ListPayEventsResponseItem> = basketWithService.createFreeEvent(createPayEventDto:CreatePayEventDto)
        call.enqueue(object: Callback<ListPayEventsResponseItem> {
            override fun onResponse(
                call: Call<ListPayEventsResponseItem>,
                response: Response<ListPayEventsResponseItem>
            ) {
                if(response.isSuccessful) {
                    allpayEventsMe.value = response.body()
                }
            }

            override fun onFailure(call: Call<ListPayEventsResponseItem>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error pay", Toast.LENGTH_LONG).show()
            }
        })

        return allpayEventsMe
    }
}