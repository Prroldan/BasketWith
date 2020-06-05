package com.basketwithapp

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp


import com.basketwithapp.models.payEvents.ListPayEventsResponse
import com.basketwithapp.models.payEvents.ListPayEventsResponseItem
import com.basketwithapp.viewmodel.PayEventsViewModel

import kotlinx.android.synthetic.main.fragment_list_pay_events_response.view.*


class MyListPayEventsResponseRecyclerViewAdapter(

) : RecyclerView.Adapter<MyListPayEventsResponseRecyclerViewAdapter.ViewHolder>() {

    private var mValues: List<ListPayEventsResponseItem?> = ArrayList()
    private val mOnClickListener: View.OnClickListener
    var payEventsViewModel: PayEventsViewModel= PayEventsViewModel()
    lateinit var idPayEventoSelecc:String

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ListPayEventsResponseItem
            idPayEventoSelecc = item.id
            val intent = Intent(MyApp.context, PayEventDetalleActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            payEventsViewModel.setIdPayEventSeleccionado(idPayEventoSelecc)
            intent.putExtra(Constants.PAY_EVENT_ID,idPayEventoSelecc )
            MyApp.context?.let { startActivity(it, intent, null) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_pay_events_response, parent, false)
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

    fun setData(listEventos: List<ListPayEventsResponseItem?>) {
        mValues = listEventos!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val nombre: TextView = mView.nombre
        val fecha: TextView = mView.fecha
        val hora: TextView = mView.hora


    }
}
