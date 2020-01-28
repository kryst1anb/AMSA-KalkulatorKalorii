package com.example.kalkulatorkalorii.JSON

import com.google.gson.annotations.SerializedName

class ResultProductList {
    @SerializedName("Results") var listItems: List<ResultProduct?>? = null
}