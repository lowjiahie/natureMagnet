package com.example.naturemagnet.entity

import androidx.room.*

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
    ],
    indices = [Index(value = ["commentID"], unique = true)]
)

data class Comment(
    @PrimaryKey(autoGenerate = true) val commentID: Long,
    val content: String?,
    val commentDatetime: String?,
    val eventLink: String?,
    @ColumnInfo(index = true) var custID: Long,
    @ColumnInfo(index = true) var postID: Long,
)
