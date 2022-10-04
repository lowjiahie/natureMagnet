package com.example.naturemagnet

import android.app.Application
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.naturemagnet.dao.ActivityDao
import com.example.naturemagnet.dao.ActivityJoinedDao
import com.example.naturemagnet.dao.CategoryDao
import com.example.naturemagnet.dao.PrefManager
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentEventEditBinding
import com.example.naturemagnet.entity.Post
import com.example.naturemagnet.repository.EventRepository
import com.example.naturemagnet.viewModel.EventDetailsViewModel
import java.text.SimpleDateFormat
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
    var in_date: EditText? = null
    var cal = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
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
        binding.apply {
            eventName.text = currentActivity?.name
            descriptionInputTextField.setText(currentActivity?.descriptions.toString())
            activitySneakPeek.setImageBitmap(currentActivity?.sneakPeek)
            inTime.setText(currentActivity?.dateTime.toString().subSequence(11, 16))
            inDate.setText(currentActivity?.dateTime.toString().subSequence(0, 10))
            inDeadline.setText(currentActivity?.registrationDeadline.toString())

            val dateSetListener =
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                }

//            imageUploader.setOnClickListener{
//                pickImageGallery()}
//            imageUploader.setOnClickListener{
//                checkValidPost(application)
//            }

//            btnTime!!.setOnClickListener(
//                object : View.OnClickListener {
//                override fun onClick(view: View) {
//                    DatePickerDialog(
//                        application,
//                        dateSetListener,
//                        // set DatePickerDialog to point to today's date when it loads up
//                        cal.get(Calendar.YEAR),
//                        cal.get(Calendar.MONTH),
//                        cal.get(Calendar.DAY_OF_MONTH)
//                    ).show()
//                }
//            })
//            btnTime.setOnClickListener {
////                val datePickerBtn = binding.btnTime
////            picker.setOnClickListener{
////                picker.show(requireActivity().supportFragmentManager, picker.toString())
////            }
////
////            picker.addOnPositiveButtonClickListener {
////                val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
////                calendar.timeInMillis = it.first
////                val format = SimpleDateFormat("yyyy-MM-dd")
////                var formattedDate = format.format(calendar.time)
////                calendar.timeInMillis = it.second
////                var formattedDate2 = format.format(calendar.time)
////
////                inDate.setText( "${formattedDate} - ${formattedDate2}")
////            }()
////
////                Log.e("Event_Edit", "Button for Time is Clicked")
////            }
//            inDeadline.setOnClickListener {
////                // Get Current Date
////                val c = Calendar.getInstance()
////                mYear = c[Calendar.YEAR]
////                mMonth = c[Calendar.MONTH]
////                mDay = c[Calendar.DAY_OF_MONTH]
////                // Get Current Time
////                mHour = c[Calendar.HOUR_OF_DAY]
////                mMinute = c[Calendar.MINUTE]
////
////                // Launch Time Picker Dialog
////                val timePickerDialog = TimePickerDialog(it.context,
////                    OnTimeSetListener { view, hourOfDay, minute -> txtTime!!.setText("$hourOfDay:$minute") },
////                    mHour,
////                    mMinute,
////                    false
////                )
////                timePickerDialog.show()
//
//                Log.e("Event_Edit", "Button for Deadline is Clicked")
//            }

//            saveButton.setOnClickListener {
//                var updatedActivity = currentActivity
//                updatedActivity?.name = eventName.text.toString()
//                updatedActivity?.descriptions = descriptionInputTextField.text.toString()

            if (currentActivity != null) {
//                    var time: String = eventTime.text.toString()
                time = time.replace('-', '/')
//                    var date: String = eventDate.text.toString()
                date = date.replace('-', '/')
//                    val deadLine: String = eventDeadline.text.toString()
            }
//        }
//        }

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
            return binding.root
        }


//    fun pickImageGallery(){
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type ="image/*"
//        startActivityForResult(intent, create_post.IMAGE_REQUEST_CODE)
//    }
//    fun checkValidPost(application : Application){
////        val sdf = SimpleDateFormat("yyyy-MM-dd")
////        val currentDate = sdf.format(Date())
////
////        try {
////            val title = binding.textinputTxt.text.toString().trim()
////            val content = binding.textinputTtl.text.toString().trim()
////            var imgPost = bitmap
////            var eventLink = null
////            val shareCount = 0
////            val postDate = currentDate
////
////            val db = NatureMagnetDB.getInstance(application)!!
////
////
////            if (title.isNotEmpty() && content.isNotEmpty() && imgPost != null) {
////                Toast.makeText(application, "The post has been published", Toast.LENGTH_SHORT)
////                    .show();
////                db.postDao()
////                    .insertPost(Post(title, content, imgPost, eventLink, shareCount, postDate, 1))
////                //navigate to post page
////                findNavController().navigate(R.id.action_createPostFragment_to_fragment_all_post)
////            } else {
////                Toast.makeText(application, "title/text/image cannot empty", Toast.LENGTH_SHORT)
////                    .show();
////            }
////        }catch (ex : Exception){
////            Toast.makeText(application, "Please pick an image", Toast.LENGTH_SHORT)
////                .show()
////
////
////        }
    }
}