package com.example.naturemagnet.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.PostDetailsVerticalItemBinding
import com.example.naturemagnet.entity.Post
import com.example.naturemagnet.entity.PostLiked
import com.example.naturemagnet.entity.PostSaved
import com.example.naturemagnet.entity.entityRelationship.CustomerWithPostSaved

class PostDetailsAdapter(private val data: List<Post>,private val postSaved:List<CustomerWithPostSaved>, val db: NatureMagnetDB) :
    RecyclerView.Adapter<PostDetailsAdapter.PostDetailsViewHolder>() {

    inner class PostDetailsViewHolder(val binding: PostDetailsVerticalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, position: Int) {
            binding.post = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostDetailsAdapter.PostDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val postListBinding = PostDetailsVerticalItemBinding.inflate(inflater, parent, false)

        return PostDetailsViewHolder(postListBinding)

    }

    override fun onBindViewHolder(holder: PostDetailsAdapter.PostDetailsViewHolder, position: Int) {
        holder.bind(data[position], position)
        var title = data[position].title
        var content = data[position].content
        val date = data[position].postDate
        val bitmap = data[position].imgPost
        val cus = db.customerDao().getCust(data[position].custID)

        if (title!!.length > 20) {
            title = title.substring(0, 20) + "...."
        }

        if (content!!.length > 30) {
            content = content.substring(0, 30) + "...."
        }


        holder.binding.postTitle.text = title
        holder.binding.postContent.text = content
        holder.binding.name.text = cus.custName
        holder.binding.postDate.text = date
        holder.binding.mediaImage.setImageBitmap(bitmap)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}