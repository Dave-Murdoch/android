package com.capgemini.menuapp

import com.capgemini.menuapp.model.*
import com.capgemini.menuapp.service.ProductService
import io.reactivex.Single
import io.reactivex.*

class MockProductServiceImpl: ProductService {

    lateinit var prodList: MutableList<Product>

    override fun getProducts(): Single<List<Product>> {
        val Product1 = Product(312, 1, 3,
            listOf(Name("mock1", "en-US"), Name("mock2", "en-CA")),
            listOf(Category(14,2), Category(12,9)),
            Recipe(99, arrayOf(Ingredient(144,0,2,1),
                            Ingredient(222,1,17,4)
            )
            )
        )
        val Product2 = Product(15, 1, 3,
            listOf(Name("mock1", "en-US"), Name("mock2", "en-CA")),
            listOf(Category(22,3), Category(35,15)),
            Recipe(99, arrayOf(Ingredient(144,0,2,1),
                Ingredient(222,1,17,4))
            )
        )

        val Product3 = Product(11, 1, 3,
            listOf(Name("mock1", "en-US"), Name("mock2", "en-CA")),
            listOf(Category(8,1), Category(7,20)),
            Recipe(99, arrayOf(Ingredient(144,0,2,1),
                Ingredient(222,1,17,4))
            )
        )

        prodList = mutableListOf(Product1,Product2,Product3)

        return Single.just(prodList)
    }

    fun MutateList()
    {
        prodList.removeAt(1)

    }



}