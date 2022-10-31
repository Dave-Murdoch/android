package com.capgemini.menuapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.service.ProductServiceImpl

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(ProductRepository(ProductServiceImpl())) as T
        }
        // TODO: Update DetailVM ctor signature once DetailVM is implemented.
//        else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
//            return ProductDetailViewModel() as T
//        }
        throw IllegalArgumentException("Uknown ViewModel class.")
    }
}