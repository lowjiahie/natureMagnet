package com.example.naturemagnet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.naturemagnet.dao.CustomerDao
import com.example.naturemagnet.dao.CustomerViewModel
import com.example.naturemagnet.databinding.FragmentUserChangepasswordBinding
import com.example.naturemagnet.databinding.FragmentUserMainBinding
import com.example.naturemagnet.entity.Customer


class fragment_user_changepassword : Fragment() {

    private lateinit var cCustomerViewModel: CustomerViewModel
    private lateinit var binding: FragmentUserChangepasswordBinding
    private lateinit var cCustomerDao: CustomerDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_main, container, false)


        cCustomerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        binding.confirmButton.setOnClickListener{
            changePassword()
        }

        return binding.root
    }

    private fun changePassword() {
        val password = binding.newPasswordText.text.toString()
        val confirmpassword = binding.confirmPasswordText.text.toString()


        if (compare(password, confirmpassword)) {


            val customers = Customer(password)
            cCustomerDao.updateCustomer(customers)

            Toast.makeText(
                context,
                "Successfully Change Password",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(context, fragment_user_main::class.java)
            startActivity(intent)
        }
    }

    private fun compare(password:String, confirmpassword: String):Boolean{
        return if(confirmpassword != password){
            Toast.makeText(context, "Password not same", Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }

    }


}