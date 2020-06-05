package com.basketwithapp.di

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.basketwithapp.DetalleFreeEventHistorialActivity
import com.basketwithapp.FreeEventDetalleActivity
import com.basketwithapp.R
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.viewmodel.FreeEventsViewModel
import kotlinx.android.synthetic.main.activity_create_pay_event.view.*
import kotlinx.android.synthetic.main.fragment_list_free_events_response.view.*

class MyListFreeEventsMeRecyclerViewAdapter(
    ctx: Context,
    items: MutableList<ListFreeEventsResponseItem?>

    ) : RecyclerView.Adapter<MyListFreeEventsMeRecyclerViewAdapter.ViewHolder>() {

    private var mValues: MutableList<ListFreeEventsResponseItem?> = items
    private val mOnClickListener: View.OnClickListener
    var freeEventsViewModel: FreeEventsViewModel = FreeEventsViewModel()
    lateinit var idFreeEventoSelecc:String

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ListFreeEventsResponseItem
            idFreeEventoSelecc = item.id
            val intent = Intent(MyApp.context, DetalleFreeEventHistorialActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            freeEventsViewModel.setIdFreeEventSeleccionado(idFreeEventoSelecc)
            intent.putExtra(Constants.FREE_EVENT_ID,idFreeEventoSelecc )
            MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_free_events_me, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        if (item != null) {
            holder.nombre.text = item.nombre
            holder.fecha.text = item.fechaEvento
            holder.hora.text = item.horaEvento
            idFreeEventoSelecc = item.id
        }


        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val nombre: TextView = mView.nombre
        val fecha: TextView = mView.fecha
        val hora: TextView = mView.hora



    }
}
