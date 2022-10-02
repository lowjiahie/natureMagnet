package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.OrderItem

@Dao
interface OrderItemDao {
    @Query("SELECT * FROM OrderItem")
    fun getOrderItemAll(): List<OrderItem>

    @Insert
    fun insertOrderItems(orderItem: List<OrderItem>)

    @Insert
    fun insertOrderItem(orderItem: OrderItem)

    @Update
    fun updateOrderItem(orderItem: OrderItem)

    @Delete
    fun deleteOrderItem(orderItem: OrderItem)
}