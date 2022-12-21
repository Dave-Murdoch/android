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

    val mockProductRepo = MockProductRepoImpl(MockProductServiceImpl("/mocks/products.json"))
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

//    @Before
//    fun setUpRxSchedulers() {
//        val immediate: Scheduler = object : Scheduler() {
//            override fun scheduleDirect(
//                @NonNull run: Runnable,
//                delay: Long,
//                @NonNull unit: TimeUnit
//            ): Disposable {
//                // this prevents StackOverflowErrors when scheduling with a delay
//                return super.scheduleDirect(run!!, 0, unit)
//            }
//
//            override fun createWorker(): Worker {
//                return ExecutorScheduler.ExecutorWorker(Runnable::run)
//            }
//        }
//        RxJavaPlugins.setInitIoSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
//        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
//        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
//        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
//    }
}