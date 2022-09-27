package com.example.naturemagnet.entity

import android.graphics.Bitmap
import androidx.room.*
import androidx.room.ForeignKey.CASCADE


//one to many (one customer can have many posts)
@Entity(
    tableName = "post",
    indices = [Index(value = ["postID"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("custID"),
        childColumns = arrayOf("custID"),
        onDelete = CASCADE
    )]
)
data class Post(
    @PrimaryKey(autoGenerate = true) val postID: Long,
    val title: String?,
    val content: String?,
//    @TypeConverters(ImageConverter::class) val imgPost: Bitmap?,
    val imgPost: Bitmap?,
    val eventLink: String?,
    val shareCount: Int?,
    val postDateTime: String?,
    @ColumnInfo(index = true) var custID: Long
)
