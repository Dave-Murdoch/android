package com.capgemini.menuapp.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.repository.ProductRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ProductListViewModel(private val productRepository: ProductRepository) : ViewModel() {
    private val products = MutableLiveData<List<Product>>()
    private val disposable = CompositeDisposable()

    init{
        hydrateProducts()
    }

    private fun hydrateProducts() {
        disposable.add(
            productRepository.getProducts()
               .subscribe({ productList ->
                   Log.d("DEBUG", "Success! ${productList.count()} products found.")
                   products.postValue(productList)
               }, { exception ->
                   Log.e("ERROR", exception.message.toString())
                   products.postValue(null)
               })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    fun getProducts(): LiveData<List<Product>> {
        return products
    }
}
