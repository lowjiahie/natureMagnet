package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.*
import com.example.naturemagnet.entity.entityRelationship.CustomerWithActivities
import com.example.naturemagnet.entity.entityRelationship.CustomerWithPostSaved

@Dao
interface PostDao{

    //Post
    @Query("SELECT * FROM Post")
    fun getAllPost(): List<Post>


    @Insert
    fun insertPosts(post: List<Post>)

    @Insert
    fun insertPost(post: Post)

    @Update
    fun updatePost(post: Post)

    @Delete
    fun deletePost(post: Post)

    //PostSaved
    @Insert
    fun insertPostSaved(postSaved: List<PostSaved>)


    //PostLiked
    @Insert
    fun insertPostLiked(postLiked: List<PostLiked>)

    //Example - Intermediate data class
    @Transaction
    @Query("SELECT * FROM Customer WHERE custID = :custID")
    fun getCustomerWithPostSaved(custID : Long): List<CustomerWithPostSaved>


}