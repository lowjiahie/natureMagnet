package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Activity")
data class Activity (
    @PrimaryKey val activityId: String,
    @ColumnInfo(name = "name") val name: String?,
)
