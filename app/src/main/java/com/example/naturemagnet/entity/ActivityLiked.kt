package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "activityLiked",
    primaryKeys = ["custID", "activityID"],
    indices = [Index( value = ["custID","activityID"], unique = true)],
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

data class ActivityLiked(
    @ColumnInfo(name = "custID") val custID: Int,
    @ColumnInfo(name = "activityID") val activityID: Int,
    @ColumnInfo(name = "dateLiked") val dateLiked: String
)
