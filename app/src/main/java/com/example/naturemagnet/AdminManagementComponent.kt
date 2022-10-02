package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.naturemagnet.databinding.FragmentAdminManagementComponentBinding

class AdminManagementComponent : Fragment() {

    private lateinit var binding: FragmentAdminManagementComponentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_admin_management_component,
            container,
            false
        )
        Log.e("whr u", "testing 123")
//        binding.updProdBtn.text = "testing"
        binding.updProdBtn.setOnClickListener {
            Log.e("Update Product", "Update Product")
//            findNavController().navigate(R.id.adminEditProduct)
        }
        binding.delProdBtn.setOnClickListener {
            Log.e("Delete Product", "Delete Product")
            //delete function
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}