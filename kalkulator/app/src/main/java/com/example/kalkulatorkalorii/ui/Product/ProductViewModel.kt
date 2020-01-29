package com.example.kalkulatorkalorii.ui.Product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kalkulatorkalorii.json.ResultProductList

class ProductViewModel : ViewModel() {

    private var searchedList = ResultProductList().listItems
}