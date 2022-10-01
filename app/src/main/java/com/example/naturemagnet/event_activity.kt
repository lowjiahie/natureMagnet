package com.example.naturemagnet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.naturemagnet.viewModel.EventViewModel
import com.example.naturemagnet.databinding.ActivityMainBinding
import com.example.naturemagnet.databinding.FragmentEventActivityBinding

class event_activity: Fragment() {
    private lateinit var binding: FragmentEventActivityBinding

    companion object {
//        fun newInstance() = event_activity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_main, container, false)

//        Log.e("event_activity", activity.toString())
        return binding.root
    }


}