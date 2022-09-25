package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "orderItem",
    primaryKeys = ["productID", "orderID"],
    indices = [Index(value = ["productID"], unique = true),Index(value = ["orderID"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("productID"),
            childColumns = arrayOf("productID"),
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = Order::class,
            parentColumns = arrayOf("orderID"),
            childColumns = arrayOf("orderID"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class OrderItem(
    val productID: Long,
    val orderID: Long,
    val orderItemQty: Int
)
