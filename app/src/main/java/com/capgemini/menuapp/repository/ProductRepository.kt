package com.capgemini.menuapp.repository
import io.reactivex.Single


class ProductRepository(private val apiProduct: ApiProduct){
  fun getProduct(): Single<List<Product>>
        return apiProduct.getProduct()
}