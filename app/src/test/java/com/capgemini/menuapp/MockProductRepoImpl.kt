package com.capgemini.menuapp

import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.service.ProductService
import io.reactivex.Single

class MockProductRepoImpl(private val productService: ProductService): ProductRepository {
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