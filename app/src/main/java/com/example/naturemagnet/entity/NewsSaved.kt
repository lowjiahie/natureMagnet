package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index

@Entity(
    tableName = "newsSaved",
    primaryKeys = ["custID", "newsID"],
    indices = [Index("custID"), Index("newsID")],
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = arrayOf("custID"),
            childColumns = arrayOf("custID"),
            onDelete = CASCADE
        ), ForeignKey(
            entity = News::class,
            parentColumns = arrayOf("newsID"),
            childColumns = arrayOf("newsID"),
            onDelete = CASCADE
        )
    ]
)

data class NewsSaved(
    val custID: String,
    val newsID: String,
    val savedDateTime: String
)
