package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naturemagnet.adapter.EventActivityClickkListener
import com.example.naturemagnet.adapter.EventAdapter
import com.example.naturemagnet.adapter.EventRectangleAdapter
import com.example.naturemagnet.dao.ActivityDao
import com.example.naturemagnet.dao.ActivityJoinedDao
import com.example.naturemagnet.dao.CategoryDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentEventMainBinding
import com.example.naturemagnet.datagenerator.SampleDataGenerator
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.ActivityJoined
import com.example.naturemagnet.repository.EventRepository
import com.example.naturemagnet.viewModel.EventDetailsViewModel
import java.util.*


class event_main : Fragment(), EventActivityClickkListener {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentEventMainBinding
    private lateinit var listener: EventActivityClickkListener
    private val sharedViewModel: EventDetailsViewModel by activityViewModels()
    private lateinit var db: NatureMagnetDB


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** Inflate the layout for this fragment */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_main, container, false)
        val application = requireNotNull(this.activity).application
        db = NatureMagnetDB.getInstance(application)!!

        val activityDao: ActivityDao = db.activityDao()
        val categoryDao: CategoryDao = db.categoryDao()
        val activityJoinedDao: ActivityJoinedDao = db.activityJoinedDao()
        val eventRepository = EventRepository(activityDao, categoryDao, activityJoinedDao)

        binding.viewModel = sharedViewModel
        listener = this

        /** get all activities the specific user has joined and display in a RecyclerView */
        val layoutManager1 = LinearLayoutManager(application)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL

        val eventAdapter1 = EventAdapter(eventRepository.getActivitiesJoinedByUser(1), this)

        binding.yourActivityCardRecyclerView.layoutManager = layoutManager1
        binding.yourActivityCardRecyclerView.adapter = eventAdapter1

        /** get all activities happening today and display in a RecyclerView */
        val layoutManager2 = LinearLayoutManager(application)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)
        val activitiesHappeningToday = eventRepository.getActivitiesByDate("$year/$month/$day")

        val eventAdapter2 = EventAdapter(activitiesHappeningToday, this)

        binding.activitiesTodayCardRecyclerView.layoutManager = layoutManager2
        binding.activitiesTodayCardRecyclerView.adapter = eventAdapter2

        /** get all activities available */
        val layoutManager3 = LinearLayoutManager(application)
        layoutManager3.orientation = LinearLayoutManager.VERTICAL
        val eventRectangleAdapter =
            EventRectangleAdapter(eventRepository.getAllActivities(), listener)
        binding.upComingEventCardRecyclerView.layoutManager = layoutManager3
        binding.upComingEventCardRecyclerView.adapter = eventRectangleAdapter

        /** binding the Button to redirect user create activity fragment "manageEvent" */
        binding.createActivityBtn.setOnClickListener { view ->
            view.findNavController().navigate(R.id.eventEdit)
//            Log.e("Event_Main_Fragment", "clicked !!!!!")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onActivityClick(view: View, activity: Activity) {
        val tempActivity = MutableLiveData<Activity>(activity)

        /** updating data in viewModel */
        sharedViewModel.setActivity(tempActivity)
//        Log.e("event_main", view.parent.)
        view.findNavController().navigate(R.id.event_details)
//        Log.e("Event_Main_Fragment", sharedViewModel.num.value.toString())
//        Log.e("Event_Main_Fragment", sharedViewModel.activity.value.toString())
    }
}