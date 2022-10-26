package com.capgemini.menuapp.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("ProductID")
    val id: Int,
    @SerializedName("ProductTypeID")
    val typeID: Int,
    @SerializedName("MenuTypeID")
    val menuTypeID: Int,
    @SerializedName("Names")
    val names: List<Name>,
    @SerializedName("Categories")
    val categories: List<Category>,
    @SerializedName("Recipe")
    val recipe: Recipe
)
