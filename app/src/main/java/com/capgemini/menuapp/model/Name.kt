package com.capgemini.menuapp.model
import com.google.gson.annotations.SerializedName

data class Name(
  @SerializedName("Name")
  val name: String = "",
  @SerializedName("LanguageID")
  val language: String = ""
)


