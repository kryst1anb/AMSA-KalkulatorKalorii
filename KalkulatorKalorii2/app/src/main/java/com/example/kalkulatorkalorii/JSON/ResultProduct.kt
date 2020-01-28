package com.example.kalkulatorkalorii.JSON

import com.google.gson.annotations.SerializedName

data class ResultProduct (
        @field:SerializedName("fields") val fields : Result?=null
)