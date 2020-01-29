package com.example.kalkulatorkalorii.json

import com.google.gson.annotations.SerializedName

data class Result (
    @field:SerializedName("_type") val _type : String? = null,
    @field:SerializedName("_id") val _id : String? = null,
    @field:SerializedName("results") val results: List<ResultProduct?>? = null
)