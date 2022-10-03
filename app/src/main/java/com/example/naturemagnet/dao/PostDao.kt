package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.*
import com.example.naturemagnet.entity.entityRelationship.CustomerWithActivities
import com.example.naturemagnet.entity.entityRelationship.CustomerWithPostLiked
import com.example.naturemagnet.entity.entityRelationship.CustomerWithPostSaved

@Dao
interface PostDao {

    //Post
    @Query("SELECT * FROM Post")
    fun getAllPost(): List<Post>

    @Query("SELECT * FROM Post WHERE Post.custID = :cusID")
    fun getCusPost(cusID: Long): List<Post>

    @Query("DELETE FROM Post WHERE Post.postID = :postID")
    fun deleteCusPost(postID: Long)

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
    fun insertPostSaveds(postSaved: List<PostSaved>)

    @Insert
    fun insertPostSaved(postSaved: PostSaved)

    @Delete
    fun deletePostSaved(postSaved: PostSaved)


    //PostLiked
    @Insert
    fun insertPostLikeds(postLiked: List<PostLiked>)

    @Insert
    fun insertPostLiked(postLiked: PostLiked)

    @Delete
    fun deletePostLiked(postLiked: PostLiked)


    //Example - Intermediate data class
    @Transaction
    @Query("SELECT * FROM Customer WHERE custID = :custID")
    fun getCustomerWithPostSaved(custID: Long): List<CustomerWithPostSaved>

    @Transaction
    @Query("SELECT * FROM Customer WHERE custID = :custID")
    fun getCustomerWithPostLiked(custID: Long): List<CustomerWithPostLiked>

}