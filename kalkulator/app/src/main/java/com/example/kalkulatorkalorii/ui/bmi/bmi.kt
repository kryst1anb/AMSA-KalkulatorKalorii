package com.example.kalkulatorkalorii.ui.bmi

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_bmi.*

class bmi : AppCompatActivity() {

    var bmiWeigth: Double = 0.0
    var bmiw: String = ""
    var bmiHeight: Double = 0.0
    var bmih: String = ""
    var bmiResult: Double = 0.0

    fun calculateBMI() {
        if (weight_bmi.text.toString() != "" && height_bmi.text.toString() != "") {
            bmiw = weight_bmi.text.toString()
            bmiWeigth = bmiw.toDouble()
            bmih = height_bmi.text.toString()
            bmiHeight = bmih.toDouble()/100
            bmiResult = bmiWeigth/(bmiHeight*bmiHeight)
            bmi_result.text = bmiResult.toString()
            if(bmiResult < 18.5)
                bmi_result_text.text = "Masz niedowagę"
            else if( bmiResult >=18.5 && bmiResult <25)
                bmi_result_text.text = "Waga prawidłowa"
            else if( bmiResult >=25 && bmiResult <30)
                bmi_result_text.text = "Masz nadwagę"
            else if( bmiResult > 30)
                bmi_result_text.text = "Otyłość!"
        }
        else
        {
            Toast.makeText(this@bmi,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }

    }
}