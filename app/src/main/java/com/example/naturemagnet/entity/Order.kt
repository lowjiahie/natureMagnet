package com.example.naturemagnet.entity

import androidx.room.*

@Entity(
    tableName = "order",
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("custID"),
        childColumns = arrayOf("custID"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["orderID"], unique = true)]
)

data class Order(
    @PrimaryKey(autoGenerate = true) val orderID: Long,
    val orderDateTime: String?,
    val aproxDate: String?,
    val orderStatus: String?,
    val orderTotalPrice: Float?,
    val shipmentName: String?,
    val shipmentAddress: String?,
    val shipmentPhnNum: String?,
    val postDateTime: String?,
    @ColumnInfo(index = true) var custID: Long
)
