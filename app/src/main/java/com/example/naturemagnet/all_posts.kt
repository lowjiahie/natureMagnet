package com.example.naturemagnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.adapter.PostDetailsAdapter
import com.example.naturemagnet.adapter.PostsAdapter
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentAllPostsBinding

class all_posts : Fragment() {

    lateinit var binding : FragmentAllPostsBinding
    lateinit var manager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_all_posts, container, false
        )

        val application = requireNotNull(this.activity).application

        val loginedCus: Long = 1

        val db = NatureMagnetDB.getInstance(application)!!
        val postList = db.postDao().getAllPost().asReversed()
        val cusPostSaved = db.postDao().getCustomerWithPostSaved(loginedCus)

        Log.e("Tag",cusPostSaved.toString())
        Log.e("Tag",postList.toString())

        manager = LinearLayoutManager(application, LinearLayoutManager.VERTICAL ,false)
        binding.postsAllRecyclerView.apply {
            adapter = PostDetailsAdapter(postList,cusPostSaved,db)
            layoutManager = manager
        }

        binding.addPostBtn.setOnClickListener{
            findNavController().navigate(R.id.createPostFragment)
        }

        return binding.root
    }

}