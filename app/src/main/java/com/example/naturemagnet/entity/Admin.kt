package com.example.naturemagnet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "admin",
    indices = [Index(value = ["adminEmail"], unique = true),Index(value = ["adminID"], unique = true)],
)
data class Admin(
    val adminName: String?,
    val adminEmail: String,
    val address: String?,
    val phone: String?,
    val password: String?,
){
    @PrimaryKey(autoGenerate = true) var adminID: Long=0
}
