package com.example.naturemagnet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.databinding.FragmentAdminManagementComponentBinding
import com.example.naturemagnet.entity.Product

class ProdAdminAdapter (private val data: List<Product>, private val productClickListener: ProductClickListener) : RecyclerView.Adapter<ProdAdminAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: FragmentAdminManagementComponentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Product){
            binding.prodAdminComp = item
            binding.imageView.setImageBitmap(item.prodImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = FragmentAdminManagementComponentBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        holder.binding.root.setOnClickListener{
            productClickListener.onProductClick(it, data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}