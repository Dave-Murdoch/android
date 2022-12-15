package com.capgemini.menuapp

import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.service.ProductServiceImpl
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductRepoUnitTest {

    val mockProductService = MockProductServiceImpl()
    val productRepository = ProductRepository(mockProductService)


    @Test
    fun initializedOnce()
    {
        val repo1 = productRepository.getProducts()
        mockProductService.MutateList()
        val repo2 = productRepository.getProducts()
        assertEquals(repo1.flattenAsObservable { it }.count().blockingGet(), repo2.flattenAsObservable { it }.count().blockingGet())
    }


}