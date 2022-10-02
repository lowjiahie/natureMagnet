package com.example.naturemagnet.Repository

import androidx.lifecycle.LiveData
import com.example.naturemagnet.dao.OrderDao
import com.example.naturemagnet.dao.OrderItemDao
import com.example.naturemagnet.dao.ProductCategoryDao
import com.example.naturemagnet.dao.ProductDao
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.entity.Order
import com.example.naturemagnet.entity.OrderItem
import com.example.naturemagnet.entity.Product
import com.example.naturemagnet.entity.ProductCategory

class EcommerceRepository(private val productCategoryDao: ProductCategoryDao, private val productDao: ProductDao,
                          private val orderDao: OrderDao, private val orderItemDao: OrderItemDao) {

    fun getAllProdCat(): List<ProductCategory> = productCategoryDao.getProdCatAll()
    suspend fun insertProdCat(category: ProductCategory) = productCategoryDao.insertProdCat(category)
    suspend fun updateProdCat(category: ProductCategory) = productCategoryDao.updateProdCat(category)
    suspend fun deleteProdCat(category: ProductCategory) = productCategoryDao.deleteProdCat(category)

    fun getAllProd(): List<Product> = productDao.getProdAll()
    suspend fun insertProd(product: Product) = productDao.insertProduct(product)
    suspend fun updateProd(product: Product) = productDao.updateProduct(product)
    suspend fun deleteProd(product: Product) = productDao.deleteProduct(product)

    fun getAllOrder() : List<Order> = orderDao.getOrderAll()
    suspend fun insertOrder(order: Order) = orderDao.insertOrder(order)
    suspend fun updateOrder(order: Order) = orderDao.updateOrder(order)
    suspend fun deleteOrder(order: Order) = orderDao.deleteOrder(order)

    fun getAllOrderItem() : List<OrderItem> = orderItemDao.getOrderItemAll()
    suspend fun insertOrderItem(orderItem: OrderItem) = orderItemDao.insertOrderItem(orderItem)
    suspend fun updateOrderItem(orderItem: OrderItem) = orderItemDao.updateOrderItem(orderItem)
    suspend fun deleteOrderItem(orderItem: OrderItem) = orderItemDao.deleteOrderItem(orderItem)
}