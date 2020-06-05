package com.basketwithapp.repository

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.MainActivity
import com.basketwithapp.api.BasketWithClient
import com.basketwithapp.api.BasketWithService
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.common.MyApp
import com.basketwithapp.dto.CreateFreeEventDto
import com.basketwithapp.dto.FreeEventoDto
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
    var responseCreateFreeEvent: MutableLiveData<FreeEventoDto> = MutableLiveData<FreeEventoDto>()




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

    fun getAllEventsMe(id:String): MutableLiveData<List<ListFreeEventsResponseItem?>> {
        val call: Call<List<ListFreeEventsResponseItem>> = basketWithService.getAllFreeEventsMe(id)
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

    fun createNewFreeEvent(createFreeEventDto: CreateFreeEventDto): MutableLiveData<FreeEventoDto> {
        val call: Call<FreeEventoDto> = basketWithService.createFreeEvent(createFreeEventDto)
        call.enqueue(object: Callback<FreeEventoDto> {
            override fun onResponse(
                call: Call<FreeEventoDto>,
                response: Response<FreeEventoDto>
            ) {
                if(response.isSuccessful) {
                    responseCreateFreeEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<FreeEventoDto>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al crear", Toast.LENGTH_LONG).show()

            }
        })

        return responseCreateFreeEvent
    }


    fun deleteFreeEvent(idEvento: String) {
        val call: Call<Void> = basketWithService.deleteFreeEvent(idEvento)
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


    fun joinFreeEvent(createFreeEventDto: CreateFreeEventDto): MutableLiveData<FreeEventoDto> {
        val call: Call<FreeEventoDto> = basketWithService.createFreeEvent(createFreeEventDto)
        call.enqueue(object: Callback<FreeEventoDto> {
            override fun onResponse(
                call: Call<FreeEventoDto>,
                response: Response<FreeEventoDto>
            ) {
                if(response.isSuccessful) {
                    responseCreateFreeEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<FreeEventoDto>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al crear", Toast.LENGTH_LONG).show()

            }
        })

        return responseCreateFreeEvent
    }

    fun editFreeEvent(idEvento: String,createFreeEventDto: CreateFreeEventDto): MutableLiveData<FreeEventoDto> {
        val call: Call<FreeEventoDto> = basketWithService.editFreeEvent(idEvento,createFreeEventDto)
        call.enqueue(object: Callback<FreeEventoDto> {
            override fun onResponse(
                call: Call<FreeEventoDto>,
                response: Response<FreeEventoDto>
            ) {
                if(response.isSuccessful) {
                    responseCreateFreeEvent.value = response.body()
                }
            }

            override fun onFailure(call: Call<FreeEventoDto>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al crear", Toast.LENGTH_LONG).show()

            }
        })

        return responseCreateFreeEvent
    }


}