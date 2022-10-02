package com.example.naturemagnet.entity.entityRelationship

import androidx.room.Embedded
import androidx.room.Relation
import com.example.naturemagnet.entity.Order
import com.example.naturemagnet.entity.Product

data class ProductWithOrders (
    @Embedded
    val product:Product,
    @Relation(
        parentColumn = "prodID",
        entityColumn = "prodID"
    )
    val order: List<Order>
)