package com.example.naturemagnet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.databinding.FragmentProductBinding
import com.example.naturemagnet.databinding.FragmentShopBinding
import com.example.naturemagnet.entity.Product

class ProductAdapter(private val data: List<Product>, val prodListClickListener: ProdListClickListener) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>()  {

    inner class MyViewHolder(val binding: FragmentProductBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Product){
            binding.prodShopComp = item
            binding.shopImage.setImageBitmap(item.prodImage)
        }
    }

    interface ProdListClickListener {
        fun onProdListItemClick(view: View, product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = FragmentProductBinding.inflate(inflater,parent,false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        holder.binding.root.setOnClickListener{
            prodListClickListener.onProdListItemClick(it,data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}