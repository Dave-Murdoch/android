package com.capgemini.menuapp.api

import com.capgemini.menuapp.model.Product
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single


class ProductServiceImpl : ProductService {

    override fun getProducts(): Single<List<Products>> {
        return Rx2AndroidNetworking.get("https://63407b4fe44b83bc73d137ee.mockapi.io//api/v1/menu")
            .build()
            .getObjectListSingle(Products::class.java)
    }

}


