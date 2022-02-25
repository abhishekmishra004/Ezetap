package com.example.networkmodule.Model

import com.google.gson.annotations.SerializedName

data class ResponseModel(@SerializedName("logo-url") val logo: String,
                         @SerializedName("heading-text") val heading:String, val uidata : List<UiData>)

data class UiData(val uitype:String,var value:String,val key: String, val hint:String)