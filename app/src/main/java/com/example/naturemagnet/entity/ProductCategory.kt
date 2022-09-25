package com.example.naturemagnet.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "productCategory",
    indices = [Index(value = ["prodCategoryID"], unique = true)],
)

data class ProductCategory(
    @PrimaryKey(autoGenerate = true) val prodCategoryID: Long,
    val categoryName: String?
)
