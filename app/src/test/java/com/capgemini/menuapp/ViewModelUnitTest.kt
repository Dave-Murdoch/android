package com.capgemini.menuapp



import androidx.annotation.NonNull
import com.capgemini.menuapp.viewmodel.ProductDetailViewModel
import com.capgemini.menuapp.viewmodel.ProductListViewModel
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


class ViewModelUnitTest {

    val mockProductRepo = MockProductRepoImpl(MockProductServiceImpl("mocks/products.json"))

    val detailViewModel = ProductDetailViewModel(mockProductRepo)


    // What we may want to test:
    // 1. Make sure that onCleared() is also clearing the CompositeDisposer (?)
    // 2. Make sure that the products are actually being hydrated when calling getProducts() or
    // getProduct()
    // 3. For the detailViewModel, ensure that the correct product is being called/hydrated


    @Test
    fun sameListCountTest()
    {
        val listViewModel = ProductListViewModel(mockProductRepo)
        val products = listViewModel.getProducts()

        assertEquals(products.value!!.size, mockProductRepo.getProducts().flattenAsObservable { it }.count().blockingGet())
    }

    @Test
    fun sameListElementsTest()
    {
        val listViewModel = ProductListViewModel(mockProductRepo)
        val products = listViewModel.getProducts()

        assertSame(products.value, mockProductRepo.getProducts().flattenAsObservable { it } )
    }

}