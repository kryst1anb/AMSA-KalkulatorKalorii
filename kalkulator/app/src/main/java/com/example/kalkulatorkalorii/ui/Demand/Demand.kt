package com.example.kalkulatorkalorii.ui.Demand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R
import kotlinx.android.synthetic.main.fragment_demand.*

class Demand : AppCompatActivity() {

    fun calculateDemand() {
        var demandWeigth: Double = 0.0
        var demandw: String = ""
        var demandHeight: Double = 0.0
        var demandh: String = ""
        var demandAge: Int = 0
        var demandRes: Double = 0.0
        var demandResult: Double = 0.0
        var demnad: Double = 1.0

        if(radio_satus_zero.isChecked) {demnad = 1.0}
        else if (radio_satus_one.isChecked) {demnad = 1.2}
        else if (radio_status_two.isChecked) {demnad = 1.4}
        else if (radio_status_three.isChecked) {demnad = 1.6}
        else if (radio_status_four.isChecked) {demnad = 1.8}
        else {demnad = 2.0}

        if (radio_woman_demand.isChecked && weight_demand.text.toString() != "" && height_demand.text.toString() != "" && age_demand.text.toString() != "" ){
            demandw = weight_demand.text.toString()
            demandWeigth = demandw.toDouble()
            demandh = height_demand.text.toString()
            demandHeight = demandh.toDouble()
            demandAge = Integer.parseInt(age_demand.text.toString())
            demandRes = (9.99 * demandWeigth) + (6.25 * demandHeight) - (4.92 * demandAge) -161
            demandResult = demandRes * demnad
            demand_result.text = demandResult.toString()
        }
        else if(radio_man_demand.isChecked && weight_demand.text.toString() != "" && height_demand.text.toString() != "" && age_demand.text.toString() != ""){
            demandw = weight_demand.text.toString()
            demandWeigth = demandw.toDouble()
            demandh = height_demand.text.toString()
            demandHeight = demandh.toDouble()
            demandAge = Integer.parseInt(age_demand.text.toString())
            demandRes = (9.99 * demandWeigth) + (6.25 * demandHeight) - (4.92 * demandAge) + 5
            demandResult = demandRes * demnad
            demand_result.text = demandResult.toString()
        }
        else{
            Toast.makeText(this@Demand,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }
    }
}