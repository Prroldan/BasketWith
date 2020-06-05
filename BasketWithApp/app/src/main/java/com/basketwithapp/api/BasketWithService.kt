package com.basketwithapp.api

import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.api.response.DetallePayEventResponse
import com.basketwithapp.dto.LoginDto
import com.basketwithapp.api.response.LoginResponse
import com.basketwithapp.api.response.UserResponse
import com.basketwithapp.dto.RegistroDto
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

    @GET("/freeEvents/me")
    fun getAllFreeEventsMe(): Call<List<ListFreeEventsResponseItem>>

    @GET("/payEvents/me")
    fun getAllPayEventsMe(): Call<List<ListPayEventsResponseItem>>

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
    fun createFreeEvent(@Body createFreeEventDto: CreateFreeEventDto): Call<>

    @POST("/payEvents/")
    fun createPayEvent(@Body createPayEventDto: CreatePayEventDto): Call<>

    @PUT("/freeEvents/")
    fun editFreeEvent(@Body editFreeEventDto: EditFreeEventDto):Call<>

    @PUT("/payEvents/")
    fun editPayEvent(@Body editPayEventDto: EditPayEventDto):Call<>

    @DELETE("/freeEvents/{id}")
    fun deleteFreeEvent(@Path("id")idEvento:String)

    @DELETE("/payEvents/{id}")
    fun deletePayEvent(@Path("id")idEvento:String)
}