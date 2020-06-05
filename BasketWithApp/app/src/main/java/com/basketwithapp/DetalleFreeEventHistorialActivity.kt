package com.basketwithapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.basketwithapp.viewmodel.DetalleFreeEventViewModel
import com.basketwithapp.viewmodel.FreeEventsViewModel

class DetalleFreeEventHistorialActivity : AppCompatActivity() {

    lateinit var idFreeEvent: String
    var detalleFreeEventViewModel: DetalleFreeEventViewModel = DetalleFreeEventViewModel()
    var freeEventViewModel: FreeEventsViewModel = FreeEventsViewModel()
    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var creadoPor: TextView
    lateinit var ubicacion: TextView
    lateinit var personasUnidas: TextView
    lateinit var borrar: Button
    lateinit var editar: Button
    var nombreAnterior: String = ""
    var listnNombres: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.basketwithapp.R.layout.activity_detalle_free_event_historial)

        nombre = findViewById(R.id.nombre)
        informacion = findViewById(R.id.informacion2)
        fecha = findViewById(R.id.fecha)
        hora = findViewById(R.id.Hora)
        creadoPor = findViewById(R.id.creadoPor)
        ubicacion = findViewById(R.id.ubicacion)
        personasUnidas = findViewById(R.id.persUnidas)
        borrar = findViewById(R.id.buttonBorrar)
        editar = findViewById(R.id.buttonEditar)


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

        borrar.setOnClickListener(View.OnClickListener {
            freeEventViewModel.deleteFreeEvent(idFreeEvent)
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        })

        editar.setOnClickListener(View.OnClickListener {

            val intent = Intent(MyApp.context, EditFreeEventActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            freeEventViewModel.setIdFreeEventSeleccionado(idFreeEvent)
            intent.putExtra(Constants.FREE_EVENT_ID_EDIT,idFreeEvent )
            MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }
        }



        )




    }
}