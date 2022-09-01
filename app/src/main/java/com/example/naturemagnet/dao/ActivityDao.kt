package com.example.naturemagnet.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.naturemagnet.entity.Activity

@Dao
interface ActivityDao {
    @Query("SELECT * FROM Activity")
    fun getAll(): List<Activity>
}