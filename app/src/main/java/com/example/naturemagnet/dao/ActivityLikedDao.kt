package com.example.naturemagnet.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.naturemagnet.entity.ActivityLiked

@Dao
interface ActivityLikedDao {
    @Insert
    fun insertActivityLiked(activityLiked: ActivityLiked)

    @Insert
    fun insertActivitiesLiked(activityLiked: List<ActivityLiked>)
}