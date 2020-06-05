package com.basketwithapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.basketwithapp.viewmodel.DetallePayEventViewModel
import com.basketwithapp.viewmodel.PayEventsViewModel

class DetallePayEventHistorialActivity : AppCompatActivity() {

    lateinit var idPayEvent: String
    var detallePayEventViewModel: DetallePayEventViewModel = DetallePayEventViewModel()
    var payEventViewModel: PayEventsViewModel = PayEventsViewModel()

    lateinit var nombre: TextView
    lateinit var informacion: TextView
    lateinit var fecha: TextView
    lateinit var hora: TextView
    lateinit var creadoPor: TextView
    lateinit var ubicacion: TextView
    lateinit var precioPorpersona: TextView
    lateinit var numContacto: TextView
    lateinit var personasUnidas: TextView
    var nombreAnterior: String = ""
    var listnNombres: MutableList<String> = mutableListOf()
    lateinit var borrar: Button
    lateinit var editar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.basketwithapp.R.layout.activity_detalle_pay_event_historial)

        nombre = findViewById(R.id.nombre)
        informacion = findViewById(R.id.informacion2)
        fecha = findViewById(R.id.fecha)
        hora = findViewById(R.id.Hora)
        creadoPor = findViewById(R.id.creadoPor)
        ubicacion = findViewById(R.id.ubicacion)
        personasUnidas = findViewById(R.id.persUnidas)
        precioPorpersona = findViewById(R.id.precioPorPersona)
        numContacto= findViewById(R.id.numcontacto)
        borrar=findViewById(R.id.buttonBorrar)
        editar=findViewById(R.id.buttonEditar)


        val extras = intent.extras

        idPayEvent = extras!!.getString(Constants.PAY_EVENT_ID).toString()


        detallePayEventViewModel =
            ViewModelProvider(this).get(DetallePayEventViewModel::class.java)
        detallePayEventViewModel.getPayEvent(idPayEvent)
            .observe(this, Observer {
                if (it != null) {
                    nombre.text = (it.nombre)
                    informacion.text = (it.informacion)
                    fecha.text = (it.fechaEvento)
                    hora.text = (it.horaEvento)
                    creadoPor.text = (it.creado_por.username)
                    ubicacion.text = (it.ubicacion)
                    precioPorpersona.text = (it.precioPorPersona.toString() + " €")
                    numContacto.text = (it.numContacto)
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
            payEventViewModel.deleteFreeEvent(idPayEvent)
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        })





        editar.setOnClickListener(View.OnClickListener {

            val intent = Intent(MyApp.context, CreatePayEventActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            payEventViewModel.setIdPayEventSeleccionado(idPayEvent)
            intent.putExtra(Constants.PAY_EVENT_ID_EDIT,idPayEvent )
            MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }
        })


    }
}
