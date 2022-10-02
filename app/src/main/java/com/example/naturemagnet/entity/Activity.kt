package com.example.naturemagnet.entity

import android.graphics.Bitmap
import androidx.room.*
import androidx.room.ForeignKey.CASCADE

//one to many (one category can have many activity)
@Entity(
    tableName = "activity",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("categoryID"),
        childColumns = arrayOf("categoryID"),
        onDelete = CASCADE
    ), ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("custID"),
        childColumns = arrayOf("custID"),
        onDelete = CASCADE
    )],
    indices = [Index(value = ["activityID"], unique = true)]

)

data class Activity(
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "datetime") val dateTime: String?,
    @ColumnInfo(name = "descriptions") val descriptions: String?,
    @ColumnInfo(name = "registration_deadline") val registrationDeadline: String?,
    @ColumnInfo(name = "date_created") val dateCreated: String?,
    @ColumnInfo(name = "venue") val venue: String?,
    @ColumnInfo(name = "sneak_peek") val sneakPeek: Bitmap?,
    @ColumnInfo(name = "participants") val participants: Int?,
    @ColumnInfo(index = true) var custID: Long,
    @ColumnInfo(index = true) var categoryID: Long
) {
    @PrimaryKey(autoGenerate = true)
    var activityID: Long = 0L

    constructor(): this (
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        null,
        0,
        1,
        1)

    constructor(sneakPeek: Bitmap?, title: String?, participants: Int?) : this(
        "example",
        title,
        "example",
        "example",
        "example",
        "example",
        "example",
        sneakPeek,
        participants,
        2,
        1
    )
}

