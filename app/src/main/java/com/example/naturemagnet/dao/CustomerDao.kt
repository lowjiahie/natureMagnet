package com.example.naturemagnet.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Query("SELECT * FROM Customer")
    fun getCustAll(): LiveData<List<Customer>>

    @Query("SELECT * FROM Customer")
    fun getAllCus(): List<Customer>

    @Query("SELECT * FROM Customer Where Customer.custID = :cusID")
    fun getCust(cusID:Long): Customer

    @Insert
    fun insertCustomers(customer: List<Customer>)

    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM Customer WHERE custEmail = :email")
    fun loginValidation(email: String):Customer

    @Update
    fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)

    @Query("DELETE FROM Customer")
    suspend fun deleteAll()
}