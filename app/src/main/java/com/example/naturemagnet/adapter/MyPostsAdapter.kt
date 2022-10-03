package com.example.naturemagnet.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.MyPostCardBinding
import com.example.naturemagnet.entity.Post

class MyPostsAdapter(private val data: MutableList<Post>,val application : Application,val db : NatureMagnetDB,val cusID :Long)  :
    RecyclerView.Adapter<MyPostsAdapter.MyPostsAdapterViewHolder>() {

    inner class MyPostsAdapterViewHolder(val binding: MyPostCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, position: Int) {
            binding.post = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostsAdapter.MyPostsAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val postListBinding = MyPostCardBinding.inflate(inflater,parent,false)

        return MyPostsAdapterViewHolder(postListBinding)

    }

    override fun onBindViewHolder(holder: MyPostsAdapter.MyPostsAdapterViewHolder, position: Int) {
        holder.bind(data[position],position)

        var title = data[position].title
        val date = data[position].postDate
        val bitmap = data[position].imgPost
        val cus = db.customerDao().getCust(data[position].custID)
        val postID = data[position].postID

        val loginedCus: Long = cusID

        holder.binding.deleteBtn.setOnClickListener{
            db.postDao().deleteCusPost(postID)
            data.remove(data[position])
            Toast.makeText(application, "Post has been deleted", Toast.LENGTH_SHORT)
                .show()
            this.notifyDataSetChanged()
        }

        if (title!!.length > 25) {
            title = title.substring(0, 25) + "...."
        }

        holder.binding.postTitle.text = title
        holder.binding.imageView.setImageBitmap(bitmap)
        holder.binding.postAuthor.text = "By ${cus.custName}"
        holder.binding.textView8.text = date

    }

    override fun getItemCount(): Int {
        return data.size
    }
}