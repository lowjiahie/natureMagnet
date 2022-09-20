package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "postLiked",
    primaryKeys = ["custID", "postID"],
    indices = [Index("custID"), Index("postID")],
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

data class PostLiked(
    val custID: String,
    val postID: String,
    val likeDateTime: String
)
