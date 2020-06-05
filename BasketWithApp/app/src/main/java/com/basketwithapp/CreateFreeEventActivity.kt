package com.basketwithapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.dto.CreateFreeEventDto
import com.basketwithapp.viewmodel.FreeEventsViewModel
import java.time.LocalDate

class CreateFreeEventActivity : AppCompatActivity() {

    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var ubicacion: TextView
    lateinit var buttonSave: Button
    var freeEventsViewModel: FreeEventsViewModel = FreeEventsViewModel()
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaCreacion: LocalDate = LocalDate.now()
    lateinit var createFreeEventDto:CreateFreeEventDto


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_free_event)

        nombre = findViewById(R.id.name)
        informacion = findViewById(R.id.informacion)
        fecha = findViewById(R.id.fechaEvento)
        hora = findViewById(R.id.horaEvento)
        ubicacion = findViewById(R.id.ubicacion)
        buttonSave = findViewById(R.id.buttonSave)

        freeEventsViewModel =
            ViewModelProvider(this).get(FreeEventsViewModel::class.java)

        buttonSave.setOnClickListener(View.OnClickListener {
            createFreeEventDto = CreateFreeEventDto(
                nombre = nombre.text.toString(),
                informacion = informacion.text.toString(),
                fechaCreacion = fechaCreacion.toString(),
                fechaEvento = fecha.text.toString(),
                ubicacion = ubicacion.text.toString(),
                horaEvento = hora.text.toString())
            freeEventsViewModel.createFreeEvent(createFreeEventDto).observe(this, Observer {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            })
        })



    }

}
