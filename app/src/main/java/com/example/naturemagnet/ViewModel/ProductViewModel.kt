package com.example.naturemagnet.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.naturemagnet.Repository.EcommerceRepository
import com.example.naturemagnet.entity.Product

class ProductViewModel(private val repository: EcommerceRepository) : ViewModel() {
    suspend fun insertProduct(product: Product) = repository.insertProd(product)
    suspend fun updateProduct(product: Product) = repository.updateProd(product)
    suspend fun deleteProduct(product: Product) = repository.deleteProd(product)
    fun getAllProd() = repository.getAllProd()
}