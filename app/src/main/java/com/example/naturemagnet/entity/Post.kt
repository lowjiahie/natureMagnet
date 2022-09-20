package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


//one to many (one customer can have many posts)
@Entity(
    tableName = "post",
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("custID"),
        childColumns = arrayOf("custID"),
        onDelete = CASCADE
    )]
)
data class Post(
    @PrimaryKey val postID: String,
    val title: String?,
    val content: String?,
    val imgPost: String?,
    val eventLink: String?,
    val shareCount: String?,
    val postDateTime: String?,
    @ColumnInfo(index = true) var custID: String
)
