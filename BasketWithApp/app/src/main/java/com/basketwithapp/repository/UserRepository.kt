package com.basketwithapp.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.api.BasketWithClient
import com.basketwithapp.api.BasketWithService
import com.basketwithapp.api.response.LoginResponse
import com.basketwithapp.api.response.UserResponse
import com.basketwithapp.common.MyApp
import com.basketwithapp.dto.LoginDto
import com.basketwithapp.dto.RegistroDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    var basketWithService: BasketWithService
    var basketWithClient: BasketWithClient =
        BasketWithClient()
    var loginResponse:MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()
    var userResponse: MutableLiveData<UserResponse> = MutableLiveData<UserResponse>()


    init {
        basketWithService = basketWithClient.getBasketWithService()

    }

    fun login(loginDto: LoginDto): MutableLiveData<LoginResponse> {
        val call: Call<LoginResponse> = basketWithService.login(loginDto)
        call.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if(response.isSuccessful) {
                    loginResponse.value = response.body()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al iniciar sesión", Toast.LENGTH_LONG).show()
            }
        })

        return loginResponse
    }

    fun registro(registroDto: RegistroDto): MutableLiveData<UserResponse> {
        val call: Call<UserResponse> = basketWithService.register(registroDto)
        call.enqueue(object: Callback<UserResponse>{

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    userResponse.value = response.body()
                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(MyApp.context, "Error al registrarse", Toast.LENGTH_LONG).show()

            }


        })
        return userResponse
    }
}