package com.basketwithapp.di


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.basketwithapp.R
import com.basketwithapp.models.freeEvents.ListFreeEventsResponseItem
import com.basketwithapp.viewmodel.FreeEventsViewModel


class ListFreeEventsResponseFragment : Fragment() {

    private lateinit var freeEventsViewModel: FreeEventsViewModel

    private lateinit var myListFreeEventsResponseRecyclerViewAdapter: MyListFreeEventsResponseRecyclerViewAdapter
    private lateinit var allFreeEvents: List<ListFreeEventsResponseItem?>

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
            inflater.inflate(R.layout.fragment_list_free_events_response_list, container, false)

        myListFreeEventsResponseRecyclerViewAdapter =
            MyListFreeEventsResponseRecyclerViewAdapter()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = myListFreeEventsResponseRecyclerViewAdapter
            }
        }
        freeEventsViewModel = FreeEventsViewModel()

        freeEventsViewModel.allfreeEvents().observe(viewLifecycleOwner, Observer {
            allFreeEvents = it
            myListFreeEventsResponseRecyclerViewAdapter.setData(allFreeEvents)
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
