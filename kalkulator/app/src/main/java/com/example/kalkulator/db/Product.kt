package com.example.kalkulator.db

import com.google.gson.annotations.SerializedName

data class Product (

    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("kcal") val kcal:Double,
    @SerializedName("fat") val fat:Double,
    @SerializedName("protein") val protein:Double,
    @SerializedName("carbo") val carbo:Double

)