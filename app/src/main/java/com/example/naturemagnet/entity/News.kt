package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "news",
)
data class News(
    @PrimaryKey val newsID: String,
    val title: String?,
    val newsLink: String?,
    val sourceName: String?,
    val publishedDateTime: String?
)
