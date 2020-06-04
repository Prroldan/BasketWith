package com.basketwithapp.api

import com.basketwithapp.dto.LoginDto
import com.basketwithapp.api.response.LoginResponse
import com.basketwithapp.api.response.UserResponse
import com.basketwithapp.dto.RegistroDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BasketWithService {

   /* @GET("events/pay/all")
    fun getAllPayEvents(): Call<>

}  @GET("events/free/all")
    fun getAllFreeEvents(): Call<>*/

    @POST("/auth/login")
    fun login(@Body loginDto: LoginDto): Call<LoginResponse>

    @POST("/user/")
    fun register(@Body registroDto: RegistroDto): Call<UserResponse>
}