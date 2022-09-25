package com.example.naturemagnet.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.entity.Product
import com.example.naturemagnet.R

class ProdRecyclerViewAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<ProdRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_product, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
    override fun getItemCount()= products.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val textViewName = itemView.findViewById<TextView>(R.id.prodName)
            textViewName.text = product.prodName
        }
    }
}