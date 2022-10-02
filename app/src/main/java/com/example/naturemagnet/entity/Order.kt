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
    val orderDateTime: String?,
    val approxDate: String?,
    val orderStatus: String?,
    val orderTotalPrice: Double?,
    val shipmentNum: String?,
    val shipmentAddress: String?,
    val shipmentPhnNum: String?,
    val postDateTime: String?,
    @ColumnInfo(index = true) var custID: Long
){
    @PrimaryKey(autoGenerate = true) var orderID: Long = 0
}
