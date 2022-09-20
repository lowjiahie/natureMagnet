package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//one customer can have many comments
//one post can have many comments
@Entity(
    tableName = "comment",
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = arrayOf("custID"),
            childColumns = arrayOf("custID"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Post::class,
            parentColumns = arrayOf("postID"),
            childColumns = arrayOf("postID"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Comment(
    @PrimaryKey val commentID: String,
    val content: String?,
    val commentDatetime: String?,
    val eventLink: String?,
    @ColumnInfo(index = true) var custID: String,
    @ColumnInfo(index = true) var postID: String,
)
