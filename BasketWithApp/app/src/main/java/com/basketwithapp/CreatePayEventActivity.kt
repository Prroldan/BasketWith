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
import com.basketwithapp.dto.CreatePayEventDto
import com.basketwithapp.viewmodel.FreeEventsViewModel
import com.basketwithapp.viewmodel.PayEventsViewModel
import kotlinx.android.synthetic.main.activity_pay_event_detalle.*
import java.time.LocalDate

class CreatePayEventActivity : AppCompatActivity() {

    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var ubicacion: TextView
    lateinit var precioPorPersona: TextView
    lateinit var numContacto: TextView
    lateinit var buttonSave: Button
    var payEventsViewModel: PayEventsViewModel = PayEventsViewModel()
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaCreacion: LocalDate = LocalDate.now()
    lateinit var createPayEventDto: CreatePayEventDto


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pay_event)

        nombre = findViewById(R.id.name)
        informacion = findViewById(R.id.informacion)
        fecha = findViewById(R.id.fechaEvento)
        hora = findViewById(R.id.horaEvento)
        ubicacion = findViewById(R.id.ubicacion)
        precioPorPersona = findViewById(R.id.precioPorPersona)
        numContacto = findViewById(R.id.numcontacto)

        buttonSave = findViewById(R.id.buttonSave)

        payEventsViewModel =
            ViewModelProvider(this).get(PayEventsViewModel::class.java)

        buttonSave.setOnClickListener(View.OnClickListener {
            createPayEventDto = CreatePayEventDto(
                nombre = nombre.text.toString(),
                informacion = informacion.text.toString(),
                fechaCreacion = fechaCreacion.toString(),
                fechaEvento = fecha.text.toString(),
                ubicacion = ubicacion.text.toString(),
                horaEvento = hora.text.toString(),
                numContacto = numContacto.text.toString() ,
                precioPorPersona= precioPorPersona.text.toString()
            )
            payEventsViewModel.createPayEvent(createPayEventDto).observe(this, Observer {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            })
        })



    }

}
