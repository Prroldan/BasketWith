package com.basketwithapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.dto.RegistroDto
import com.basketwithapp.viewmodel.UserViewModel

class RegisterActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel
    lateinit var registroDto: RegistroDto


    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var edad: EditText
    lateinit var dni: EditText
    lateinit var btnRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        username = findViewById(R.id.username)
        name = findViewById(R.id.name)
        surname = findViewById(R.id.surname)
        edad = findViewById(R.id.edad)
        password = findViewById(R.id.password)
        btnRegister = findViewById(R.id.buttonRegister)
        dni = findViewById(R.id.dni)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btnRegister.setOnClickListener(View.OnClickListener {
            registroDto = RegistroDto(
               name.text.toString(),
               surname.text.toString(),
               edad.text.toString(),
               dni.text.toString(),
               username.text.toString(),
               password.text.toString()
            )
            userViewModel.doRegister(registroDto).observe(this, Observer {
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            })
        })




    }



}
