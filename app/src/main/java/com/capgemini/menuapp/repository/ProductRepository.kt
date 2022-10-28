package com.capgemini.menuapp.repository
import com.capgemini.menuapp.service.ProductService
import io.reactivex.Single


class ProductRepository(private val productService: ProductService){
  fun getProducts(): Single<List<Product>> {
      return productService.getProducts()
  }
}