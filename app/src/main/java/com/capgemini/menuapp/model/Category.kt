package com.capgemini.menuapp.model
import com.google.gson.annotations.SerializedName

data class Category(
  @SerializedName("CategoryID")
  val id: Int = 0,
  @SerializedName("DisplayOrder")
  val displayOrder: Int = 0
)
