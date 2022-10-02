package com.example.naturemagnet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.databinding.PostsVerticalItemBinding
import com.example.naturemagnet.entity.Post

class PostsAdapter(private val data: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostAdapterViewHolder>() {

    inner class PostAdapterViewHolder(val binding: PostsVerticalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, position: Int) {
            binding.post = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val postListBinding = PostsVerticalItemBinding.inflate(inflater,parent,false)

        return PostAdapterViewHolder(postListBinding)

    }

    override fun onBindViewHolder(holder: PostsAdapter.PostAdapterViewHolder, position: Int) {
        holder.bind(data[position],position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}