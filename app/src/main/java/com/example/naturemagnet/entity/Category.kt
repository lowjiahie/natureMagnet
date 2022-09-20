package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "category",
)
data class Category(
    @PrimaryKey val categoryID: String,
    val title: String?,
    val description: String?,
    val icon: String?
)
