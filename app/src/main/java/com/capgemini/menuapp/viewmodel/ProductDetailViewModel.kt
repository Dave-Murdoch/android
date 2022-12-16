package com.capgemini.menuapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.repository.ProductRepository
import com.capgemini.menuapp.repository.ProductRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class ProductDetailViewModel(private val productRepository: ProductRepository): ViewModel() {
    private val product =  MutableLiveData<Product?>()
    private val disposable = CompositeDisposable()
    private var productId: Int = 0


    private fun hydrateproduct() {
        disposable.add(
            productRepository.getProduct(productId)
                .subscribe({productItem ->
                    product.postValue(productItem)
                },
                    {exception ->
                        Log.e("Error", exception.message.toString())
                        product.postValue(null)
                    })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    fun getProduct(): LiveData<Product?>{
        return product
    }

    fun setProduct(id: Int){
        productId = id
        hydrateproduct()
    }


}