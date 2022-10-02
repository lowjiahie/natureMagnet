package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.ProductCategory

@Dao
interface ProductCategoryDao {
    @Query("SELECT * FROM productCategory")
    fun getProdCatAll(): List<ProductCategory>

    @Insert
    fun insertProdCats(prodCategory: List<ProductCategory>)

    @Insert
    fun insertProdCat(prodCategory: ProductCategory)

    @Update
    fun updateProdCat(prodCategory: ProductCategory)

    @Delete
    fun deleteProdCat(prodCategory: ProductCategory)
}