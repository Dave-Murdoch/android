package com.capgemini.menuapp.repository

import com.capgemini.menuapp.service.ProductService
import com.capgemini.menuapp.model.Product
import io.reactivex.Single


class ProductRepository(private val productService: ProductService) {
    private lateinit var products: Single<List<Product>>

    fun getProducts(): Single<List<Product>> {
        if (!::products.isInitialized) {
            products = productService.getProducts()
        }
        return products
    }

    fun getProduct(productID: Int): Single<Product> {
        return getProducts().flattenAsObservable { it }
            .filter { it.id == productID }
            .firstOrError()
    }
}