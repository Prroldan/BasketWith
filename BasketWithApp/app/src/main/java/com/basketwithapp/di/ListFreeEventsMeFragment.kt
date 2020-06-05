package com.basketwithapp.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.basketwithapp.R
import com.basketwithapp.api.SharedPreferencesManager
import com.basketwithapp.common.Constants

import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.viewmodel.FreeEventsViewModel

class ListFreeEventsMeFragment : Fragment() {

    private lateinit var freeEventsViewModel: FreeEventsViewModel

    private lateinit var adapterMe: MyListFreeEventsMeRecyclerViewAdapter
    private  lateinit var allFreeMeEvents: MutableList<ListFreeEventsResponseItem?>
    private var eventosAll: RecyclerView? = null

    private var columnCount = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_list_free_events_me_list, container, false)
        eventosAll = view.findViewById(R.id.list)



        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

            }
        }
        freeEventsViewModel = FreeEventsViewModel()
        loadEventos()



        return view
    }


    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListFreeEventsResponseFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    fun loadEventos() {
        allFreeMeEvents = mutableListOf()
        if (columnCount <= 1) {
            eventosAll!!.layoutManager = LinearLayoutManager(context)
        } else {
            eventosAll!!.layoutManager = GridLayoutManager(context, columnCount)
        }
        adapterMe =
            context?.let { it1 ->
                MyListFreeEventsMeRecyclerViewAdapter(
                    it1,
                    allFreeMeEvents

                )

            }!!
        eventosAll!!.adapter = adapterMe
        activity?.let {
            SharedPreferencesManager.getStringValue(Constants.USER_ID)?.let { it1 ->
                freeEventsViewModel.allfreeEventsMe(it1)?.observe(
                    it,
                    Observer<List<ListFreeEventsResponseItem?>> { todos ->
                        allFreeMeEvents!!.addAll(todos!!)
                        adapterMe!!.notifyDataSetChanged()
                    })
            }
        }
    }
}

