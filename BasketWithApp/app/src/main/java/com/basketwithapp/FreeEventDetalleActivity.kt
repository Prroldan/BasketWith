package com.basketwithapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.common.Constants
import com.basketwithapp.viewmodel.DetalleFreeEventViewModel


class FreeEventDetalleActivity : AppCompatActivity() {

    lateinit var idFreeEvent: String
    var detalleFreeEventViewModel: DetalleFreeEventViewModel = DetalleFreeEventViewModel()
    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var creadoPor: TextView
    lateinit var ubicacion: TextView
    lateinit var personasUnidas: TextView
    var nombreAnterior: String = ""
    var listnNombres: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.basketwithapp.R.layout.activity_free_event_detalle)

        nombre = findViewById(R.id.nombre)
        informacion = findViewById(R.id.informacion2)
        fecha = findViewById(R.id.fecha)
        hora = findViewById(R.id.Hora)
        creadoPor = findViewById(R.id.creadoPor)
        ubicacion = findViewById(R.id.ubicacion)
        personasUnidas = findViewById(R.id.persUnidas)


        val extras = intent.extras

        idFreeEvent = extras!!.getString(Constants.FREE_EVENT_ID).toString()
        Constants.FREE_EVENT_ID = ""


        detalleFreeEventViewModel =
            ViewModelProvider(this).get(DetalleFreeEventViewModel::class.java)
        detalleFreeEventViewModel.getFreeEvent(idFreeEvent)
            .observe(this, androidx.lifecycle.Observer {
                if (it != null) {
                    nombre.text = (it.nombre)
                    informacion.text = (it.informacion)
                    fecha.text = (it.fechaEvento)
                    hora.text = (it.horaEvento)
                    creadoPor.text = (it.creado_por.username)
                    ubicacion.text = (it.ubicacion)
                    for (User in it.listPersonasUnidas) {
                        listnNombres.add(User.name)
                    }
                    for (nombre in listnNombres) {
                        if (nombre == listnNombres.get(0)) {
                            nombreAnterior == nombre
                        } else {
                            nombreAnterior = nombreAnterior + ", " + listnNombres
                        }
                    }
                    personasUnidas.text = (nombreAnterior)


                }
            })


    }
}
