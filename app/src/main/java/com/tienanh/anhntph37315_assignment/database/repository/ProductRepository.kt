package com.tienanh.anhntph37315_assignment.database.repository

import androidx.lifecycle.LiveData
import com.tienanh.anhntph37315_assignment.database.dao.ProductDao
import com.tienanh.anhntph37315_assignment.database.entities.Products

class ProductRepository(private val productDao: ProductDao) {
    val getAllProduct: LiveData<List<Products>> = productDao.getAllProduct()
    fun getItemProduct(id: Int): LiveData<Products> = productDao.getItemProduct(id)
    suspend fun addProduct(products: Products) {
        productDao.addProduct(products)
    }
}