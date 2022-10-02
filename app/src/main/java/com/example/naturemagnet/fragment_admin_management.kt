package com.example.naturemagnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.naturemagnet.ViewModel.ProductViewModel
import com.example.naturemagnet.adapter.ProdAdminAdapter
import com.example.naturemagnet.adapter.ProductAdapter
import com.example.naturemagnet.dao.ProductDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentAdminManagementBinding
import com.example.naturemagnet.databinding.FragmentAdminManagementComponentBinding
import com.example.naturemagnet.entity.Product


class fragment_admin_management : Fragment()  {

    private lateinit var binding: FragmentAdminManagementBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var prodDao: ProductDao
    lateinit var prodList : List<Product>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_admin_management,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        manager = LinearLayoutManager(application)
        prodDao = NatureMagnetDB.getInstance(application)!!.productDao()
        prodList = prodDao.getProdAll()
        binding.recyclerView.apply{
            adapter = ProdAdminAdapter(prodList)
            layoutManager = manager
        }

        binding.addProdBtn.setOnClickListener {
            findNavController().navigate(R.id.adminAddProduct)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}