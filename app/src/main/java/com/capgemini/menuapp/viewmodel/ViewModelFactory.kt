package com.capgemini.menuapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capgemini.menuapp.repository.ProductRepositoryImpl
import com.capgemini.menuapp.service.ProductServiceImpl

class ViewModelFactory() : ViewModelProvider.Factory {
    private val url = "https://63407b4fe44b83bc73d137ee.mockapi.io/api/v1/menu"
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(ProductRepositoryImpl(ProductServiceImpl(url))) as T
        }

        else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            return ProductDetailViewModel(productRepository = ProductRepositoryImpl(ProductServiceImpl(url))) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}