package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.naturemagnet.adapter.ProductAdapter
import com.example.naturemagnet.dao.ProductDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentShopBinding
import com.example.naturemagnet.entity.Product

class fragment_shop : Fragment(), ProductAdapter.ProdListClickListener {

    private lateinit var binding: FragmentShopBinding
    private lateinit var prodDao: ProductDao
    lateinit var prodList : List<Product>
    lateinit var listener: ProductAdapter.ProdListClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shop,
            container,
            false
        )
        listener = this
        val application = requireNotNull(this.activity).application
        val manager = GridLayoutManager(application, 2)
        prodDao = NatureMagnetDB.getInstance(application)!!.productDao()
        prodList = prodDao.getProdAll()
        binding.recyclerView.apply{
            adapter = ProductAdapter(prodList, listener)
            layoutManager = manager
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onProdListItemClick(view: View, product:Product) {
        Log.e("Product Detail", "Product Detail")
        view.findNavController().navigate(R.id.fragment_prodDetail)
    }
}