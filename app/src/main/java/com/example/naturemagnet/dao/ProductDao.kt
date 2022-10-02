package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Product
import com.example.naturemagnet.entity.ProductCategory

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product")
    fun getProdAll(): List<Product>

    @Query(
        "SELECT * FROM Product JOIN ProductCategory ON Product.prodCategoryID = ProductCategory.prodCategoryID"
    )
    fun loadProductAndProductCat(): Map<ProductCategory, List<Product>>

    @Query(
        "SELECT * FROM Product WHERE Product.productID = :productID"
    )
    fun loadProductDetail(productID: Int): Product

    @Insert
    fun insertProducts(product: List<Product>)

    @Insert
    fun insertProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}