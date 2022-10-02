package com.example.naturemagnet

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.naturemagnet.dao.OrderDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentTrackShippingBinding
import com.example.naturemagnet.entity.Order

class fragment_trackShipping : Fragment() {

    private lateinit var binding: FragmentTrackShippingBinding
    private lateinit var orderDao: OrderDao
    lateinit var orderDetail : Order

    //        init {
//            itemView.setOnClickListener(this)
//        }
//
//        override fun onClick(view: View?) {
//            val position = bindingAdapterPosition
//
//            if (position != RecyclerView.NO_POSITION) {
//                listener.itemClick(position)
//            }
//        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            com.example.naturemagnet.R.layout.fragment_track_shipping,
            container,
            false
        )

        val shippingNum = binding.inputShippingNum.text.toString()
        val btnTrackOrder = binding.trackButton

        btnTrackOrder.setOnClickListener(){
            trackOrder(shippingNum)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun trackOrder(shippingNum : String) {

        val application = requireNotNull(this.activity).application
        orderDao = NatureMagnetDB.getInstance(application)!!.orderDao()
        orderDetail = orderDao.loadOrderDetail(shippingNum)

    }

}