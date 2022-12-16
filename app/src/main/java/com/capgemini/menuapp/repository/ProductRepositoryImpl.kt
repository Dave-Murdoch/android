package com.capgemini.menuapp.repository

import com.capgemini.menuapp.service.ProductService
import com.capgemini.menuapp.model.Product
import io.reactivex.Single


class ProductRepositoryImpl(private val productService: ProductService) : ProductRepository {
    private lateinit var products: Single<List<Product>>

    override fun getProducts(): Single<List<Product>> {
        if (!::products.isInitialized) {
            products = productService.getProducts()
        }
        return products
    }

    override fun getProduct(productID: Int): Single<Product> {
        return getProducts().flattenAsObservable { it }
            .filter { it.id == productID }
            .firstOrError()
    }
}