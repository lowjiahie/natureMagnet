package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.naturemagnet.dao.ActivityDao
import com.example.naturemagnet.dao.ActivityJoinedDao
import com.example.naturemagnet.dao.CategoryDao
import com.example.naturemagnet.entity.PrefManager
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentEventEditBinding
import com.example.naturemagnet.repository.EventRepository
import com.example.naturemagnet.viewModel.EventDetailsViewModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [event_edit.newInstance] factory method to
 * create an instance of this fragment.
 */
class event_edit : Fragment() {
    lateinit var binding: FragmentEventEditBinding
    private lateinit var db: NatureMagnetDB
    private lateinit var prefManager: PrefManager
    private val sharedViewModel: EventDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** local variables */
        binding = FragmentEventEditBinding.inflate(inflater, container, false)
        val application = requireNotNull(this.activity).application
        db = NatureMagnetDB.getInstance(application)!!
        prefManager = PrefManager(application)
        val currentActivity = sharedViewModel.activity.value

        /** preparing repository instances for accessing database */
        val activityDao: ActivityDao = db.activityDao()
        val categoryDao: CategoryDao = db.categoryDao()
        val activityJoinedDao: ActivityJoinedDao = db.activityJoinedDao()
        val eventRepository = EventRepository(activityDao, categoryDao, activityJoinedDao)

        /** formate the date */
        val dateTime: String = currentActivity?.dateTime.toString()
        var date: String = dateTime.subSequence(0, 10) as String
        date = date.replace('-', '/')

        /** formate time of the activity */
        var time: String = dateTime.subSequence(11, 16) as String
        var hr = time.split(':')[0]
        val min = time.split(':')[1]
        if (hr.toInt() - 12 >= 0) {
            if (hr.toInt() - 12 > 0) {
                hr = (hr.toInt() - 12).toString()
            }
            time = hr + " : " + min + " P.M."
        } else {
            time = hr + " : " + min + " A.M."
        }
        val formatedDateTime: String = date + "\nEvent Start @ " + time

        /** binding the activity object to livedata */
        binding.apply{
            Log.e("event_edit.kt", sharedViewModel.parent?.value.toString())
            eventName.text = currentActivity?.name
            descriptionInputTextField.setText(currentActivity?.descriptions.toString())
            activitySneakPeek.setImageBitmap(currentActivity?.sneakPeek)

            saveButton.setOnClickListener {
                var updatedActivity = currentActivity
                updatedActivity?.name = eventName.text.toString()
                updatedActivity?.descriptions = descriptionInputTextField.text.toString()

                if (currentActivity != null) {
                    val c = Calendar.getInstance()
                    val year = c.get(Calendar.YEAR)
                    val month = c.get(Calendar.MONTH) + 1
                    val day = c.get(Calendar.DAY_OF_MONTH)

//                    val sdf = SimpleDateFormat("yyyy/M/dd hh:mm:ss")
//                    val currentDate = sdf.format(Date())
                }
            }
        }

        // Inflate the layout for this fragment
//        val picker =
//            MaterialTimePicker.Builder()
//            .setTimeFormat(TimeFormat.CLOCK_12H)
//            .setHour(12)
//            .setMinute(10)
//            .setTitleText("Select Appointment time")
//            .setTheme(R.style.ThemeOverlay_App_DatePicker)
//            .build()
//        picker.show(event_edit, "tag")
        return inflater.inflate(R.layout.fragment_event_edit, container, false)
    }
}