package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Post
import com.example.naturemagnet.entity.PostLiked

@Dao
interface PostLIkedDao {
    @Query("SELECT * FROM PostLiked")
    fun getAllPostLiked(): List<PostLiked>


    @Insert
    fun insertPostLikeds(post: List<PostLiked>)

    @Insert
    fun insertPostLiked(post: PostLiked)

    @Update
    fun updatePostLiked(post: PostLiked)

    @Delete
    fun deletePostLiked(post: PostLiked)
}