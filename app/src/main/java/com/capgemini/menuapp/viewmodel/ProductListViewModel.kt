package com.capgemini.menuapp.viewmodel


import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.model.Product
import io.reactivex.Single


class ProductListViewModel(private val productRepository: ProductRepository) {
    init{
        getProducts()
    }

    private fun getProducts() : Single<List<Product>> {
       return productRepository.getProducts()
    }

}
