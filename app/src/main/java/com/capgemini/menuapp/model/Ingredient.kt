package com.capgemini.menuapp.model

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("ProductCode")
    val productCode: Int,
    @SerializedName("MinQuantity")
    val minQuantity: Int,
    @SerializedName("MaxQuantity")
    val maxQuantity: Int,
    @SerializedName("DefaultQuantity")
    val defaultQuantity: Int
)
