package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.Customer

@Dao
interface CustomerDao {
    @Query("SELECT * FROM Customer")
    fun getCustAll(): List<Customer>

    @Query("SELECT * FROM Customer Where Customer.custID = :cusID")
    fun getCust(cusID:Long): Customer

    @Insert
    fun insertCustomer(customer: List<Customer>)

    @Update
    fun updateCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)

}