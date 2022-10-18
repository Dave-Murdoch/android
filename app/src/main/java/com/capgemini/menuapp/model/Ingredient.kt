package com.capgemini.menuapp.model

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("ProductCode")
    val ProductCode: Int,
    @SerializedName("MinQuantity")
    val MinQuantity: Int,
    @SerializedName("MaxQuantity")
    val MaxQuantity: Int,
    @SerializedName("DefaultQuantity")
    val DefaultQuantity: Int
)
