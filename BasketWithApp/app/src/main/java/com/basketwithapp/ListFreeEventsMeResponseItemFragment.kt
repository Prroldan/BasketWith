package com.basketwithapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.basketwithapp.dummy.DummyContent
import com.basketwithapp.dummy.DummyContent.DummyItem
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.viewmodel.FreeEventsViewModel


class ListFreeEventsMeResponseItemFragment : Fragment() {

    private lateinit var freeEventsViewModel: FreeEventsViewModel

    private lateinit var adapterMe: MyListFreeEventsMeRecyclerViewAdapter
    private lateinit var allFreeMeEvents: List<ListFreeEventsResponseItem?>

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
            inflater.inflate(R.layout.fragment_list_free_events_me_response_item_list, container, false)

        adapterMe = MyListFreeEventsMeRecyclerViewAdapter()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyListFreeEventsMeRecyclerViewAdapter()
            }
        }
        freeEventsViewModel = FreeEventsViewModel()

        freeEventsViewModel.allfreeEventsMe().observe(viewLifecycleOwner, Observer {
            allFreeMeEvents = it
            adapterMe.setData(allFreeMeEvents)
        })

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
}
