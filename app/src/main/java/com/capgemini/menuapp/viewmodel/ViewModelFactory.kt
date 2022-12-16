package com.capgemini.menuapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capgemini.menuapp.repository.ProductRepositoryImpl
import com.capgemini.menuapp.service.ProductServiceImpl

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(ProductRepositoryImpl(ProductServiceImpl())) as T
        }

        else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            return ProductDetailViewModel(productRepository = ProductRepositoryImpl(ProductServiceImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}