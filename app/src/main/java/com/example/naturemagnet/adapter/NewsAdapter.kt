package com.example.naturemagnet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.databinding.CardItemBinding
import com.example.naturemagnet.databinding.NewsHorizontalItemBinding
import com.example.naturemagnet.entity.AQI
import com.example.naturemagnet.entity.News

class NewsAdapter(private val data: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {

    inner class NewsAdapterViewHolder(val binding: NewsHorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News,position: Int) {
            binding.news = item
            binding.indexNumNews.text = (position+1).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val newsListBinding = NewsHorizontalItemBinding.inflate(inflater,parent,false)

        return NewsAdapterViewHolder(newsListBinding)

    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsAdapterViewHolder, position: Int) {
        holder.bind(data[position],position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}