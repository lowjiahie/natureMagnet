package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Admin(
    @PrimaryKey val adminID: String,
    val adminName: String?,
    val adminEmail: String?,
    val address: String?,
    val phone: String?,
    val password: String?,
)
