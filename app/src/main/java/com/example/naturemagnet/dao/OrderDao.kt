package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Order
import com.example.naturemagnet.entity.Product

@Dao
interface OrderDao {
    @Query("SELECT * FROM `order`")
    fun getOrderAll(): List<Order>

    @Query("SELECT * FROM `order` WHERE `order`.shipmentNum = :shippingNum")
    fun loadOrderDetail(shippingNum: String): Order

    @Insert
    fun insertOrders(order: List<Order>)

    @Insert
    fun insertOrder(order: Order)

    @Update
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)
}