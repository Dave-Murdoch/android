package com.capgemini.menuapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
    override fun onBindViewHolder(
        dataHolder: ProductListViewAdapter.DataViewHolder,
        position: Int) {

        // Pull a product with a given position
        val product = dataset[position]
        // Set the data for a product/position
        dataHolder.bind(product,position)

        // Commented out until listeners are added
        // dataHolder.setListeners()

    }

    // Get the length of our dataset
    override fun getItemCount(): Int {
        return dataset.size
    }

    //Create a ViewHolder to get and set the date
    inner class DataViewHolder(
        private val productView: View
    ): RecyclerView.ViewHolder(productView){
        //Pull the TextView and the current position/product in our RecyclerView
        // TODO("Check with other team for name of R.id.")
        private val productId = productView.findViewById<TextView>(R.id.product_id)

        // Initialize to null to ensure we are not initializing with values already in use
        private var currentProduct: Product? = null
        private var currentPosition: Int = -1

        // Set the data of the RecyclerView at a given position
        fun bind(product: Product, position: Int){
            productId.text = product.id.toString()
            this.currentProduct = product
            this.currentPosition = position
        }
    }
}