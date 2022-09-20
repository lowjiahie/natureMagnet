package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//one to many (one customer can have many posts)
@Entity(
    tableName = "reply",
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = arrayOf("custID"),
            childColumns = arrayOf("custID"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Comment::class,
            parentColumns = arrayOf("commentID"),
            childColumns = arrayOf("commentID"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Reply(
    @PrimaryKey val replyID: String,
    val content: String?,
    val replyDatetime: String?,
    val eventLink: String?,
    @ColumnInfo(index = true) var custID: String,
    @ColumnInfo(index = true) var commentID: String
)
