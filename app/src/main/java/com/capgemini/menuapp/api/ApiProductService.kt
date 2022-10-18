package com.capgemini.menuapp.api

import com.capgemini.menuapp.model.Products
import io.reactivex.Single



interface ApiProductService {
   fun getProducts() : Single<List<Products>>
}