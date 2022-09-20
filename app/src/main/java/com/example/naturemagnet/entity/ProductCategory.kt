package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "productCategory",
)

data class ProductCategory(
    @PrimaryKey val prodCategoryID: String,
    val categoryName: String?
)
