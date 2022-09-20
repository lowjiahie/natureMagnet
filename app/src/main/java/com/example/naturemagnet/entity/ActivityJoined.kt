package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "activityJoined",
    primaryKeys = ["custID", "activityID"],
    indices = [Index("custID"), Index("activityID")],
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = arrayOf("custID"),
            childColumns = arrayOf("custID"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Activity::class,
            parentColumns = arrayOf("activityID"),
            childColumns = arrayOf("activityID"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ActivityJoined(
    val custID: String,
    val activityID: String,
    val dateJoined: String
)
