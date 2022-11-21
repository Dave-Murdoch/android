package com.capgemini.menuapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.service.ProductServiceImpl

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(ProductRepository(ProductServiceImpl())) as T
        }

        else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            return ProductDetailViewModel(productRepository = ProductRepository(ProductServiceImpl())) as T
        }
        throw IllegalArgumentException("Uknown ViewModel class.")
    }
}