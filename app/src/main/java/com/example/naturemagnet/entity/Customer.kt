package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "customer",
)
data class Customer(
    @PrimaryKey val custID: String,
    @ColumnInfo(name = "custName") val name: String?,
    @ColumnInfo(name = "custEmail") val email: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "address") val address: String?
)