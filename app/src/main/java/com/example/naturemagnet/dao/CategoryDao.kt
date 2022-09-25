package com.example.naturemagnet.dao

import androidx.room.*
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    fun getAll(): List<Category>

    @Insert
    fun insertCategory(category: Category)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}