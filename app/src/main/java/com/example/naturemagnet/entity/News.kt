package com.example.naturemagnet.entity

import androidx.room.*

@Entity(
    tableName = "news",
    indices = [Index(value = ["newsID"], unique = true)]
)
data class News(
    @PrimaryKey(autoGenerate = true) val newsID: Long,
    val title: String?,
    val newsLink: String?,
    val sourceName: String?,
    val publishedDateTime: String?
)
