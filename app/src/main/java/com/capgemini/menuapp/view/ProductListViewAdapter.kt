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
        val productView = LayoutInflater.from(context).inflate(R.id.item_layout,parent,false)
        return DataViewHolder(productView)
    }

    // Replaces contents of ListView
    override fun onBindViewHolder(dataHolder: ProductListViewAdapter.DataViewHolder, position: Int) {

        // Pull a product with a given position
        val product = dataset[position]
        // Set the data for a product/position
        dataHolder.setData(product,position)

        // Commented out until listeners are added
        // dataHolder.setListeners()

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}