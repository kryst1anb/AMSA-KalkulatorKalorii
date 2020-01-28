package com.example.kalkulatorkalorii.ui.bmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Obliczanie BMI"
    }
    val text: LiveData<String> = _text
}