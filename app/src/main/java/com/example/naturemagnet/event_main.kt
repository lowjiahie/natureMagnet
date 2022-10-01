package com.example.naturemagnet

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.adapter.EventAdapter
import com.example.naturemagnet.adapter.EventRectangleAdapter
import com.example.naturemagnet.databinding.FragmentEventMainBinding
import com.example.naturemagnet.datagenerator.SampleDataGenerator
import com.example.naturemagnet.entity.Activity


class event_main : Fragment() {
    // TODO: Rename and change types of parameters
    private var activityAdapter: EventAdapter? = null
    private var activityRecyclerView: RecyclerView? = null
    lateinit var binding: FragmentEventMainBinding
//    private lateinit var listener: EventRectangleAdapter.ActivityClickListener

    //    fun onAttach(context: Context) {
//        super.onAttach(context)
//        DBHelper = DatabaseHelper(activity)
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_main, container, false)
        val application = requireNotNull(this.activity).application

        /** get all activities posted by u and display in a RecyclerView */
        val layoutManager1 = LinearLayoutManager(application);
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL
        val eventAdapter = EventAdapter(SampleDataGenerator.injectActivities(application))
        binding.yourActivityCardRecyclerView.layoutManager = layoutManager1
        binding.yourActivityCardRecyclerView.adapter = eventAdapter

        /** get all activities happening today and display in a RecyclerView */
        val layoutManager2 = LinearLayoutManager(application);
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        binding.activitiesTodayCardRecyclerView.layoutManager = layoutManager2
        binding.activitiesTodayCardRecyclerView.adapter = eventAdapter

        val layoutManager3 = LinearLayoutManager(application);
        layoutManager3.orientation = LinearLayoutManager.VERTICAL
//        listener = this
        val eventRectangleAdapter = EventRectangleAdapter(SampleDataGenerator.injectActivities(application))
        binding.upComingEventCardRecyclerView.layoutManager = layoutManager3
        binding.upComingEventCardRecyclerView.adapter = eventRectangleAdapter

        /** binding the Button to redirect user to another fragment "manageEvent" */
//        binding.createActivityBtn.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.eventEdit)
//            Log.e("Event_Main_Fragment", "clicked !!!!!")
//        }
        return binding.root
    }

//    override fun onActivityClick(view: View, activity: Activity) {
//        Log.e("Event_Main_Fragment", "$view clicked !!!!!")
//    }
}