package com.capgemini.menuapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.capgemini.menuapp.R
import com.capgemini.menuapp.model.Product
import com.capgemini.menuapp.viewmodel.ProductDetailViewModel
import com.capgemini.menuapp.viewmodel.ViewModelFactory
import org.w3c.dom.Text
import java.util.*


class ProductDetail : AppCompatActivity() {

    lateinit var productDetailViewModel: ProductDetailViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_product_detail)
        productDetailViewModel = ViewModelFactory().create(ProductDetailViewModel::class.java)
        LinearLayoutManager(this)

        val productId= intent.getIntExtra("ProductId", -1)

        productDetailViewModel.setProduct(productId)
        productDetailViewModel.getProduct().observe (this) {
            renderProduct(it)
        }


    }

    private fun renderProduct(product: Product?)
    {
        val productId = product?.id.toString()
        val productName = product?.names?.get(0)?.name
        val productRecipe = product?.recipe?.ingredients
        var recipeText = ""

        findViewById<TextView>(R.id.productId).text = "Product ID: " + productId
        findViewById<TextView>(R.id.productName).text ="Product Name: " + productName

        if (productRecipe != null) {
            for (ing in 0..productRecipe.size-1) {
                recipeText =
                    recipeText + "Ingredient: " + productRecipe.get(ing).productCode + "; Quantity: " + productRecipe.get(
                        ing
                    ).defaultQuantity + "\n"
            }
            findViewById<TextView>(R.id.recipe).text = recipeText
        }
        else
        {
            findViewById<TextView>(R.id.recipe).text = ""
        }
    }








}
