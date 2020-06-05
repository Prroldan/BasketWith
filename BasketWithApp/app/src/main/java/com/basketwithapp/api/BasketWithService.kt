package com.basketwithapp.api

import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.api.response.DetallePayEventResponse
import com.basketwithapp.api.response.LoginResponse
import com.basketwithapp.api.response.UserResponse
import com.basketwithapp.dto.*
import com.basketwithapp.models.User
import com.basketwithapp.models.freeEvents.ListFreeEventsResponse
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.models.payEvents.ListPayEventsResponse
import com.basketwithapp.models.payEvents.ListPayEventsResponseItem
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface BasketWithService {

    @GET("/payEvents/")
    fun getAllPayEvents(): Call<List<ListPayEventsResponseItem>>

    @GET("/freeEvents/me/{id}")
    fun getAllFreeEventsMe(@Path("id")id: String): Call<List<ListFreeEventsResponseItem>>

    @GET("/payEvents/me/{id}")
    fun getAllPayEventsMe(@Path("id")id:String): Call<List<ListPayEventsResponseItem>>

    @GET("/payEvents/{id}")
    fun getPayEventsById(@Path("id")idEvento:String): Call<DetallePayEventResponse>

    @GET("/freeEvents/{id}")
    fun getFreeEventsById(@Path("id")idEvento:String): Call<DetalleFreeEventResponse>

    @GET("/freeEvents/")
    fun getAllFreeEvents(): Call<List<ListFreeEventsResponseItem>>

    @POST("/auth/login")
    fun login(@Body loginDto: LoginDto): Call<LoginResponse>

    @POST("/user/")
    fun register(@Body registroDto: RegistroDto): Call<UserResponse>

    @POST("/freeEvents/")
    fun createFreeEvent(@Body createFreeEventDto: CreateFreeEventDto): Call<FreeEventoDto>

    @POST("/payEvents/")
    fun createPayEvent(@Body createPayEventDto: CreatePayEventDto): Call<PayEventDto>

    @PUT("/freeEvents/{id}")
    fun editFreeEvent(@Path("id")id:String,@Body editFreeEventDto: CreateFreeEventDto):Call<FreeEventoDto>

    @PUT("/payEvents/")
    fun editPayEvent(@Path("id")id:String,@Body editPayEventDto: CreatePayEventDto):Call<PayEventDto>

    @DELETE("/freeEvents/{id}")
    fun deleteFreeEvent(@Path("id")idEvento:String): Call<Void>

    @DELETE("/payEvents/{id}")
    fun deletePayEvent(@Path("id")idEvento:String): Call<Void>

    @POST("/freeEvents/{idUser}/{idEvento}")
    fun joinAFreeEvent(@Path("id")idUser:String, @Path("id")idEvento:String)

    @POST("/payEvents/{idUser}/{idEvento}")
    fun joinAPayEvent(@Path("id")idUs:String, @Path("id")idEvent:String)

    @DELETE("/freeEvents/{idUser}/{idEvento}")
    fun exitFreeEvent(@Path("id")idUser:String, @Path("id")idEvento:String)

    @DELETE("/payEvents/{idUser}/{idEvento}")
    fun exitPayEvent(@Path("id")idUser:String, @Path("id")idEvento:String)
}