package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

//one to many (one category can have many activity)
@Entity(
    tableName = "activity",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("categoryID"),
        childColumns = arrayOf("categoryID"),
        onDelete = CASCADE
    )]
)
data class Activity (
    @PrimaryKey val activityId: String,
    val name: String?,
    val title: String?,
    val dateTime: String?,
    val descriptions: String?,
    val registrationDeadline: String?,
    val dateCreated: String?,
    val venue: String?,
    val sneakPeek: String?,
    val participants: String?,
    @ColumnInfo(index = true) var categoryID: String
)
