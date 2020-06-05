package com.basketwithapp

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.basketwithapp.api.response.DetalleFreeEventResponse
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.basketwithapp.models.freeEvents.ListFreeEventsResponse
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.viewmodel.DetalleFreeEventViewModel
import com.basketwithapp.viewmodel.FreeEventsViewModel

import kotlinx.android.synthetic.main.fragment_list_free_events_response.view.*


class MyListFreeEventsResponseRecyclerViewAdapter(

) : RecyclerView.Adapter<MyListFreeEventsResponseRecyclerViewAdapter.ViewHolder>() {

    private var mValues: List<ListFreeEventsResponseItem?> = ArrayList()
    private val mOnClickListener: View.OnClickListener
    var freeEventsViewModel:FreeEventsViewModel = FreeEventsViewModel()
    lateinit var idFreeEventoSelecc:String

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ListFreeEventsResponseItem
            idFreeEventoSelecc = item.id
            val intent = Intent(MyApp.context, FreeEventDetalleActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            freeEventsViewModel.setIdFreeEventSeleccionado(idFreeEventoSelecc)
            intent.putExtra(Constants.FREE_EVENT_ID,idFreeEventoSelecc )
            MyApp.context?.let { startActivity(it, intent, null) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_free_events_response, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        if (item != null) {
            holder.nombre.text = item.nombre
            holder.fecha.text = item.fechaEvento
            holder.hora.text = item.horaEvento
        }


        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun setData(listEventos: List<ListFreeEventsResponseItem?>) {
        mValues = listEventos!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val nombre: TextView = mView.nombre
        val fecha: TextView = mView.fecha
        val hora: TextView = mView.hora


    }
}
