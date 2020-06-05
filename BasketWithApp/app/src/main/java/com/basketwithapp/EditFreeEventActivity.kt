package com.basketwithapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.api.SharedPreferencesManager
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.basketwithapp.dto.CreateFreeEventDto
import com.basketwithapp.models.freeEvents.EventoGratuito
import com.basketwithapp.repository.FreeEventsRepository
import com.basketwithapp.viewmodel.FreeEventsViewModel
import java.time.LocalDate

class EditFreeEventActivity : AppCompatActivity() {

    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var ubicacion: TextView
    lateinit var editar: Button
    var freeEventsViewModel: FreeEventsViewModel = FreeEventsViewModel()
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaCreacion: LocalDate = LocalDate.now()
    lateinit var createFreeEventDto: CreateFreeEventDto
    lateinit var eventoGratuito: LiveData<DetalleFreeEventResponse>
    var freeEventRepository:FreeEventsRepository = FreeEventsRepository()
    lateinit var id:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_free_event)



        nombre = findViewById(R.id.name)
        informacion = findViewById(R.id.informacion)
        fecha = findViewById(R.id.fechaEvento)
        hora = findViewById(R.id.horaEvento)
        ubicacion = findViewById(R.id.ubicacion)
        editar = findViewById(R.id.buttonSave)



        //id = SharedPreferencesManager.getStringValue(Constants.FREE_EVENT_ID_EDIT).toString()
        id = freeEventsViewModel.getIdFreeEventSeleccionado().value.toString()
        eventoGratuito=freeEventRepository.getOneFreeEvent(id)

        nombre.setText(eventoGratuito.value?.nombre)
        informacion.setText(eventoGratuito.value?.informacion)
        fecha.setText(eventoGratuito.value?.fechaEvento)
        hora.setText(eventoGratuito.value?.horaEvento)
        ubicacion.setText(eventoGratuito.value?.ubicacion)


        freeEventsViewModel =
            ViewModelProvider(this).get(FreeEventsViewModel::class.java)
        editar.setOnClickListener(View.OnClickListener {
            createFreeEventDto= CreateFreeEventDto(
            nombre = nombre.text.toString(),
            informacion = informacion.text.toString(),
            fechaCreacion = fechaCreacion.toString(),
            fechaEvento = fecha.text.toString(),
            ubicacion = ubicacion.text.toString(),
            horaEvento = hora.text.toString())

            freeEventsViewModel.editFreeEvent(id,createFreeEventDto).observe(this, Observer {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            })



        })





    }
}
