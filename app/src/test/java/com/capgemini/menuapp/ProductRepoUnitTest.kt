package com.capgemini.menuapp

import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.repository.ProductRepositoryImpl
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Test

class ProductRepoUnitTest {

    val mockProductService = MockProductServiceImpl("/mocks/products.json")
    val productRepository = ProductRepositoryImpl(mockProductService)
    val testProdId = 312


    @Test
    fun initializedOnce()
    {
        val repo1 = productRepository.getProducts()
        mockProductService.MutateList()
        val repo2 = productRepository.getProducts()
        assertEquals(repo1.flattenAsObservable { it }.count().blockingGet(), repo2.flattenAsObservable { it }.count().blockingGet())
    }

    @Test
    fun productsNotNull()
    {
        assertNotNull(productRepository.getProducts())
    }

    @Test
    fun productNotNull()
    {
        assertNotNull(productRepository.getProduct(testProdId))
    }

//    @Test
//    fun sameMemAddress()
//    {
//        val product1 = productRepository.getProduct(312)
//        val product2 = productRepository.getProduct(312)
//        assertSame(product1, product2)
//    }
//
//    @Test
//    fun returnTypeProducts()
//    {
//        val productRetType = productRepository.getProducts()
//
//        assertTrue(productRetType::class == Single<List<Product>>::class)
//    }

    @Test
    fun testInstanceOfProducts() {
        val subClass = productRepository.getProducts()
        assertTrue(subClass is Single<List<Product>>)
    }

    @Test
    fun testInstanceOfProduct() {
        val subClass = productRepository.getProduct(testProdId)
        assertTrue(subClass is Single<Product>)
    }

    //TODO:
    //mock product repo impl and view model test
    //product service refactored to take a string for the URL









}