package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.PostLiked
import com.example.naturemagnet.entity.PostSaved

@Dao
interface PostSavedDao {
    @Query("SELECT * FROM PostSaved")
    fun getAllPostSaved(): List<PostSaved>

    @Insert
    fun insertPostSaveds(post: List<PostSaved>)

    @Insert
    fun insertPostSaved(post: PostSaved)

    @Update
    fun updatePostSaved(post: PostSaved)

    @Delete
    fun deletePostSaved(post: PostSaved)
}