package com.basketwithapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.basketwithapp.api.response.LoginResponse
import com.basketwithapp.repository.UserRepository
import com.basketwithapp.api.response.UserResponse
import com.basketwithapp.dto.LoginDto
import com.basketwithapp.dto.RegistroDto

class UserViewModel: ViewModel() {
    private var userRepository = UserRepository()
    private lateinit var response: LiveData<LoginResponse>
    private lateinit var userResponse: LiveData<UserResponse>

    init {

    }

    fun doLogin(loginDto: LoginDto): LiveData<LoginResponse> {
        response = userRepository.login(loginDto)
        return response
    }

    fun doRegister(registroDto: RegistroDto): LiveData<UserResponse> {
        userResponse = userRepository.registro(registroDto)
        return userResponse
    }

}