package com.capgemini.menuapp.service

import com.capgemini.menuapp.model.Product
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ProductServiceImpl : ProductService {
    override fun getProducts(): Single<List<Product>> {
        return Rx2AndroidNetworking.get("https://63407b4fe44b83bc73d137ee.mockapi.io/api/v1/menu")
            .build()
            .getObjectListSingle(Product::class.java)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}