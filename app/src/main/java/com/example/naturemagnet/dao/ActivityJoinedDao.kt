package com.example.naturemagnet.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.naturemagnet.entity.ActivityJoined

@Dao
interface ActivityJoinedDao {
    @Insert
    fun insertActivityJoined(activityJoined: ActivityJoined)

    @Insert
    fun insertActivitiesJoined(activityJoined: List<ActivityJoined>)
}