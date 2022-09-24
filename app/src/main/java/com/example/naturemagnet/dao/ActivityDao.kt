package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Activity

@Dao
interface ActivityDao {
    @Query("SELECT * FROM Activity")
    fun getAll(): List<Activity>

    @Insert
    fun insertActivity(activity:Activity)

    @Update
    fun updateUsers(activity: Activity)

    @Delete
    fun deleteActivity(activity:Activity)
}