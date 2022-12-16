package com.capgemini.menuapp.repository

import com.capgemini.menuapp.model.Product
import io.reactivex.Single

interface ProductRepository{
    fun getProducts() : Single<List<Product>>

    fun getProduct(productID: Int) : Single<Product>
}

