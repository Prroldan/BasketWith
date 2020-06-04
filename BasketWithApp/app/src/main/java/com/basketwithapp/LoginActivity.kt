package com.basketwithapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.api.SharedPreferencesManager
import com.basketwithapp.common.Constants
import com.basketwithapp.dto.LoginDto
import com.basketwithapp.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel
    lateinit var loginDto: LoginDto


    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        username = findViewById(R.id.username)
        password = findViewById(R.id.surname)
        btnLogin = findViewById(R.id.buttonLogin)
        btnRegister = findViewById(R.id.buttonRegister)

        btnLogin.setOnClickListener(View.OnClickListener {
            loginDto = LoginDto(
                username.text.toString(),
                password.text.toString()
            )
            userViewModel.doLogin(loginDto).observe(this, Observer {
                SharedPreferencesManager.setStringValue(Constants.TOKEN, it.token)
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            })
        })

        btnRegister.setOnClickListener(View.OnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
            })



    }
}
