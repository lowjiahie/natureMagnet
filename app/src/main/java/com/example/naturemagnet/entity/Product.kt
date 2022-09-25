package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
    ]
)

//data class Product(
//    @PrimaryKey val productID: String,
//    val prodName: String?,
//    val prodPrice: String?,
//    val prodDescription: String?,
//    val prodQuantityStock: String?,
//    val prodImage: String?,
//    @ColumnInfo(index = true) var categoryID: String,
//    @ColumnInfo(index = true) var adminID: String
//)

data class Product(
    val prodName: String,
    val prodPrice: String,
)