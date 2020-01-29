package com.example.kalkulatorkalorii.api

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kalkulatorkalorii.json.Result
import com.example.kalkulatorkalorii.json.ResultProductList
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class apiConnect : ViewModel() {
    companion object {
        private var searchedProductsList = ResultProductList()
    }

    fun apiConnection(typedSearch: String): ResultProductList {

        try {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://nutritionix-api.p.rapidapi.com/v1_1/search/")
                .get()
                .addHeader("x-rapidapi-host", "nutritionix-api.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "375c5ab2fcmsh7b1007a6516e98ep10931fjsn19eabd2048af")
                .build()

//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException?) {
//                    call.cancel()
//                    Log.e("ERROR: ", e.toString())
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call?, response: Response) {
//                    val myResponse = response.body()?.string()
//                    var gson = Gson()
//                    val data = gson.fromJson(myResponse, Result::class.java)
//
//                    searchedProductsList.listItems = data.results
//                }
//            })
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return searchedProductsList
    }
}