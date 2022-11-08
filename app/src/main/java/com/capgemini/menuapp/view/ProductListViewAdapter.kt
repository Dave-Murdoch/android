package com.capgemini.menuapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capgemini.menuapp.R
import com.capgemini.menuapp.model.Product

class ProductListViewAdapter(
    private val context: Context,
    private val dataset: ArrayList<Product>):
    RecyclerView.Adapter<ProductListViewAdapter.DataViewHolder>() {

    // Inflating the product layout, returns type DataViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder {
        TODO("Check with other team for name of R.id.")
      // attachToRoot is false: RecyclerView attaches to the View Hierarchy at runtime
        val view = LayoutInflater.from(context).inflate(R.id.item_layout,parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewAdapter.DataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}