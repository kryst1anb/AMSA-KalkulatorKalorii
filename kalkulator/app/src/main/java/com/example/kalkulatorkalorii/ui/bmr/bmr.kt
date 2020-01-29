package com.example.kalkulatorkalorii.ui.bmr

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_bmr.*

class bmr : AppCompatActivity() {

    var bmrWeigth: Double = 0.0
    var bmrw: String = ""
    var bmrHeight: Double = 0.0
    var bmrh: String = ""
    var bmrAge: Int = 0
    var bmrResult: Double = 0.0



    fun calculateBMR() {
        if (radio_man_bmr.isChecked && weight_bmr.text.toString() != "" && height_bmr.text.toString() != "" && age_bmr.text.toString() != "") {
            bmrw = weight_bmr.text.toString()
            bmrWeigth = bmrw.toDouble()
            bmrh = height_bmr.text.toString()
            bmrHeight = bmrh.toDouble()
            bmrAge = Integer.parseInt(age_bmr.text.toString())
            bmrResult = (9.99 * bmrWeigth) + (6.25 * bmrHeight) - (4.92 * bmrAge) + 5
            bmi_result.text = bmrResult.toString()
        }
        else if(radio_woman_bmr.isChecked && weight_bmr.text.toString() != "" && height_bmr.text.toString() != "" && age_bmr.text.toString() != "")
        {
            bmrw = weight_bmr.text.toString()
            bmrWeigth = bmrw.toDouble()
            bmrh = height_bmr.text.toString()
            bmrHeight = bmrh.toDouble()
            bmrAge = Integer.parseInt(age_bmr.text.toString())
            bmrResult = (9.99 * bmrWeigth) + (6.25 * bmrHeight) - (4.92 * bmrAge) -161
            bmi_result.text = bmrResult.toString()
        }
        else
        {
            Toast.makeText(this@bmr,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }
    }
}