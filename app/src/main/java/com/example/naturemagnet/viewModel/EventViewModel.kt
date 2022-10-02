package com.example.naturemagnet.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.naturemagnet.dao.ActivityDao
import com.example.naturemagnet.dao.CategoryDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.Category
import com.example.naturemagnet.repository.EventRepository

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var activities: List<Activity>
    private lateinit var categories: List<Category>
    private lateinit var eventRepository: EventRepository
    private var db = NatureMagnetDB.getInstance(application)

    init {
        Log.d("Activity_Fragment", "EventViewModel created !")
        var activityDao: ActivityDao = db!!.activityDao()
        var categoryDao: CategoryDao = db!!.categoryDao()
        eventRepository = EventRepository(activityDao, categoryDao)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Activity_Fragment", "EventViewModel destroyed !")
    }

    //Activity
    private fun getAllActivities() {
        activities = eventRepository.getAllActivities()
    }

    private fun getActivity(activity: Activity): Activity? {
        return eventRepository.getActivity(activity.activityID)
    }

    //Category
    private fun getAllCategories() {
        categories = eventRepository.getAllCategories()
    }

    private fun getCategory(category: Category): Category? {
        return eventRepository.getCategory(category.categoryID)
    }
}