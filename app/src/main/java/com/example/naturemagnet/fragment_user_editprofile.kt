package com.example.naturemagnet

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.naturemagnet.dao.CustomerDao
import com.example.naturemagnet.dao.CustomerViewModel
import com.example.naturemagnet.dao.PrefManager
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentUserEditprofileBinding
import com.example.naturemagnet.entity.Customer


class fragment_user_editprofile : Fragment() {

    private lateinit var cCustomerViewModel: CustomerViewModel
    private lateinit var binding: FragmentUserEditprofileBinding
    private lateinit var prefManager: PrefManager
    private lateinit var db : NatureMagnetDB
    private lateinit var customer : Customer
    lateinit var cCustomerDao: CustomerDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_editprofile, container, false)

        binding.confirmButton.setOnClickListener(){
            findNavController().navigate(R.id.fragment_user_main)
        }


        cCustomerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        binding.confirmButton.setOnClickListener{
            updateCustomer()
        }


        val application = requireNotNull(this.activity).application

        prefManager = PrefManager(this.requireActivity())
        db = NatureMagnetDB.getInstance(application)!!
        cCustomerDao = db.customerDao()
        customer = cCustomerDao.loginValidation(prefManager.getEmail().toString())
        binding.editName.setText(customer.custName.toString())
        binding.editEmail.setText(customer.custEmail)
        binding.editPhone.setText(customer.phone.toString())
        binding.editAddress.setText(customer.address.toString())


        return binding.root
    }


    private fun updateCustomer() {
        val name = binding.editName.text.toString()
        val email = binding.editEmail.text.toString()
        val phone = binding.editPhone.text.toString()
        val address = binding.editAddress.text.toString()

        val customers = Customer(name, email, phone, address)
        cCustomerDao.updateCustomer(customers)

        Toast.makeText(
            context,
            "Successfully Update",
            Toast.LENGTH_LONG
        ).show()


    }


}