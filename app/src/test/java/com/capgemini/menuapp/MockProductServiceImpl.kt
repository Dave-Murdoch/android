package com.capgemini.menuapp

import com.capgemini.menuapp.model.*
import com.capgemini.menuapp.service.ProductService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import io.reactivex.*

class MockProductServiceImpl(private val file : String): ProductService {

    lateinit var prodList: MutableList<Product>

    override fun getProducts(): Single<List<Product>> {
        val json = this::class.java.classLoader.getResource(file).readText()
        prodList = Gson().fromJson(json, object : TypeToken<MutableList<Product>>(){}.type)
        return Single.just(prodList)
    }

    fun MutateList()
    {
        prodList.removeAt(1)

    }



}