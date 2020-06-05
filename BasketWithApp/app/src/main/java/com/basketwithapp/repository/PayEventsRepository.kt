package com.basketwithapp.repository

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.MainActivity
import com.basketwithapp.api.BasketWithClient
import com.basketwithapp.api.BasketWithService
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.api.response.DetallePayEventResponse
import com.basketwithapp.common.MyApp
import com.basketwithapp.dto.CreateFreeEventDto
import com.basketwithapp.dto.CreatePayEventDto
import com.basketwithapp.dto.FreeEventoDto
import com.basketwithapp.dto.PayEventDto
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
    var responseCreatePayEvent: MutableLiveData<PayEventDto> = MutableLiveData<PayEventDto>()




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

    fun getallPayEventsMe(idUser:String): MutableLiveData<List<ListPayEventsResponseItem?>> {
        val call: Call<List<ListPayEventsResponseItem>> = basketWithService.getAllPayEventsMe(idUser)
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

    fun createNewPayEvent(createPayEventDto: CreatePayEventDto): MutableLiveData<PayEventDto>{
        val call: Call<PayEventDto> = basketWithService.createPayEvent(createPayEventDto)
        call.enqueue(object: Callback<PayEventDto> {
            override fun onResponse(
                call: Call<PayEventDto>,
                response: Response<PayEventDto>
            ) {
                if(response.isSuccessful) {
                    responseCreatePayEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<PayEventDto>, t: Throwable) {
                val intent = Intent(MyApp.context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }
            }
        })

        return responseCreatePayEvent
    }

    fun deletePayEvent(idEvento: String) {
        val call: Call<Void> = basketWithService.deletePayEvent(idEvento)
        call.enqueue(object: Callback<Void> {
            override fun onResponse(
                call: Call<Void>,
                response: Response<Void>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(MyApp.context, "Evento borrado correctamente",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al borrar", Toast.LENGTH_LONG).show()

            }
        })

    }

    fun editPayEvent(idEvento: String,createPayEventDto: CreatePayEventDto): MutableLiveData<PayEventDto> {
        val call: Call<PayEventDto> = basketWithService.editPayEvent(idEvento,createPayEventDto)
        call.enqueue(object: Callback<PayEventDto> {
            override fun onResponse(
                call: Call<PayEventDto>,
                response: Response<PayEventDto>
            ) {
                if(response.isSuccessful) {
                    responseCreatePayEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<PayEventDto>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al crear", Toast.LENGTH_LONG).show()

            }
        })

        return responseCreatePayEvent
    }

}