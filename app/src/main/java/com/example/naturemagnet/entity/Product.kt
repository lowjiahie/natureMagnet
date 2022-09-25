package com.example.naturemagnet.entity

import android.graphics.Bitmap
import androidx.room.*

@Entity(
    tableName = "product",
    foreignKeys = [
        ForeignKey(
            entity = ProductCategory::class,
            parentColumns = arrayOf("prodCategoryID"),
            childColumns = arrayOf("prodCategoryID"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Admin::class,
            parentColumns = arrayOf("adminID"),
            childColumns = arrayOf("adminID"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["productID"], unique = true)],
)

data class Product(
    @PrimaryKey(autoGenerate = true) val productID: Long,
    val prodName: String?,
    val prodPrice: String?,
    val prodDescription: String?,
    val prodQuantityStock: String?,
    val prodImage: Bitmap?,
    @ColumnInfo(index = true) var prodCategoryID: Long,
    @ColumnInfo(index = true) var adminID: Long
)