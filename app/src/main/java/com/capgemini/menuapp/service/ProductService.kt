package com.capgemini.menuapp.service

import com.capgemini.menuapp.model.Product
import io.reactivex.Single



interface ProductService {
   fun getProducts() : Single<List<Product>>
}