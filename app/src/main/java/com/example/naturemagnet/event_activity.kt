package com.example.naturemagnet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.naturemagnet.viewModel.EventViewModel
import com.example.naturemagnet.databinding.ActivityMainBinding

class event_activity (val backgroundSneakPeek:Int, val iconImage: Int, val cardTitle: String, val cardParticipants: String): Fragment() {

    companion object {
//        fun newInstance() = event_activity()
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EventViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_event_activity, container, false)
//    }


}