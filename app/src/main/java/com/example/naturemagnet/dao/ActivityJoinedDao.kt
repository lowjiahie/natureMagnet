package com.example.naturemagnet.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.ActivityJoined

@Dao
interface ActivityJoinedDao {
    @Query("SELECT * FROM ActivityJoined")
    fun getAll(): List<ActivityJoined>

    @Query("SELECT * FROM ActivityJoined WHERE ActivityJoined.activityID == :activityId")
    fun getActivityJoined(activityId: Long): ActivityJoined

    @Insert
    fun insertActivityJoined(activityJoined: ActivityJoined)

    @Insert
    fun insertActivitiesJoined(activityJoined: List<ActivityJoined>)
}