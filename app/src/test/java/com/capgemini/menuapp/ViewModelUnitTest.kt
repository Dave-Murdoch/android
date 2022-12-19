package com.capgemini.menuapp



import com.capgemini.menuapp.viewmodel.ProductDetailViewModel
import com.capgemini.menuapp.viewmodel.ProductListViewModel
import org.junit.Test
import org.junit.Assert.*

class ViewModelUnitTest {

    val mockProductRepo = MockProductRepoImpl(MockProductServiceImpl())
    val listViewModel = ProductListViewModel(mockProductRepo)
    val detailViewModel = ProductDetailViewModel(mockProductRepo)


    // What we may want to test:
    // 1. Make sure that onCleared() is also clearing the CompositeDisposer (?)
    // 2. Make sure that the products are actually being hydrated when calling getProducts() or
    // getProduct()
    // 3. For the detailViewModel, ensure that the correct product is being called/hydrated


    @Test
    fun hydrateProductsSuccessTest()
    {
        val products = listViewModel.getProducts()

        assertEquals(products.value?.size, mockProductRepo.getProducts().flattenAsObservable { it }.count().blockingGet())
    }


}