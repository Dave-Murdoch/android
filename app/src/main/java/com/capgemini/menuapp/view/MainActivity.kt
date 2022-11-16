package com.capgemini.menuapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capgemini.menuapp.R
import com.capgemini.menuapp.databinding.ActivityMainBinding
import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.viewmodel.ProductListViewModel
import com.capgemini.menuapp.viewmodel.ViewModelFactory
import com.capgemini.menuapp.view.ProductListViewAdapter
import kotlinx.android.synthetic.main.fragment_first.*


// TODO: Rename Activity to ProductListActivity
class MainActivity : AppCompatActivity() {
    private lateinit var productListViewModel: ProductListViewModel
    private lateinit var adapter: ProductListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        LinearLayoutManager(this).also { recyclerView.layoutManager = it }
        adapter = ProductListViewAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        productListViewModel.getProducts().observe(this, Observer {
            renderList(it)
            recyclerView.visibility = View.VISIBLE
        })
    }

    private fun renderList(Products: List<Product>) {
        adapter.addData(Products)
        adapter.notifyDataSetChanged()
    }


    private fun setupViewModel() {
        // This will work, but using the built-in ViewModelProvider provides some optimizations.
        //productListViewModel = ViewModelFactory().create(ProductListViewModel::class.java)

        productListViewModel = ViewModelProvider(this, ViewModelFactory())
            .get(ProductListViewModel::class.java)
    }
}