package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.naturemagnet.databinding.FragmentEventDetailsBinding
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.viewModel.EventDetailsViewModel

class event_details : Fragment() {
    private var binding: FragmentEventDetailsBinding? = null
    /** viewModel important */
    private val sharedViewModel: EventDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding?.apply {
            /** using viewModel set on another fragment */
            val currentActivity = sharedViewModel.activity.value
            val dateTime: String = currentActivity?.dateTime.toString()
            var date: String = dateTime.subSequence(0, 10) as String
            date = date.replace('-', '/')

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

            detailsCardTitle.text = currentActivity?.name
            detailsCardSneakpeek.setImageBitmap(currentActivity?.sneakPeek)
            detailsCardIcon.setImageBitmap(currentActivity?.sneakPeek)
            detailsCardDatetime.text = formatedDateTime
            detailsCardDesc.text = currentActivity?.descriptions

            detailsCardJoinBtn.setOnClickListener {
                //TODO: insert an activityJoined entries using current custId & activityId
                Log.e("Event_ Details", "join btn clicked")
            }

            detailsCardQuitBtn.setOnClickListener {
                //TODO: delete specific activityJoined entries using with custId & activityId
                Log.e("Event_ Details", "join btn clicked")
            }

            detailsCardCancelBtn.setOnClickListener {
                //TODO: bring user back to previous fragment
                Log.e("Event_ Details", "join btn clicked")
            }
        }
//        Log.e("event_details", sharedViewModel.activity.value.toString())
//        Log.e("event_details", sharedViewModel.num.value.toString())

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}