package com.example.naturemagnet.entity

import android.graphics.Bitmap
import androidx.room.*

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
    ],
    indices = [Index(value = ["replyID"], unique = true)],
)

data class Reply(
    @PrimaryKey(autoGenerate = true) var replyID: Long,
    val content: String?,
    val replyDatetime: String?,
    val eventLink: String?,
    @ColumnInfo(index = true) var custID: Long,
    @ColumnInfo(index = true) var commentID: Long
){
    constructor(content:String, replyDatetime:String, eventLink:String?, custID:Long, commentID:Long)
            : this(0, content, replyDatetime, eventLink, custID, commentID)
}
