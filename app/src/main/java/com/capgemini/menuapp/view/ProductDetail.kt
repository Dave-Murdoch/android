package com.capgemini.menuapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capgemini.menuapp.R
import com.capgemini.menuapp.viewmodel.ProductDetailViewModel
import com.capgemini.menuapp.viewmodel.ViewModelFactory


class ProductDetail : AppCompatActivity() {

    lateinit var productDetailViewModel: ProductDetailViewModel

    companion object {
        const val PRODUCTID = "id"
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_product_detail)
        setupViewModel()
        setupUI()
        setupObserver()

    }

    private fun setupObserver() {
        TODO("Not yet implemented")
    }

    private fun setupUI() {
        TODO("Not yet implemented")
    }

    private fun setupViewModel() {
        productDetailViewModel = ViewModelProvider(this,
        ViewModelFactory()).get(ProductDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }





}