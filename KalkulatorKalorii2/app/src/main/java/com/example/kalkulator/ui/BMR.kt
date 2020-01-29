package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R
import kotlinx.android.synthetic.main.fragment_bmr.*

class BMR : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_bmr)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_kalorie -> openFragmentContainerSearch()
            R.id.action_products -> openFragmentContainerList()
            R.id.action_bmr -> openBMR()
        }

        return super.onOptionsItemSelected(item)
    }

    fun openFragmentContainerSearch() {
        val intent = Intent(
            this,
            FragmentContainerSearch::class.java
        )
        startActivity(intent)
    }

    fun openFragmentContainerList() {
        val intent = Intent(this, FragmentContainerList::class.java)
        startActivity(intent)
    }

    fun openBMR()
    {
        val intent = Intent(this, BMR::class.java)
        startActivity(intent)
    }

    var bmrWeigth: Double = 0.0
    var bmrw: String = ""
    var bmrHeight: Double = 0.0
    var bmrh: String = ""
    var bmrAge: Int = 0
    var bmra: String = ""
    var bmrResult: Double = 0.0

    fun calculateBMR() {
        if (radio_man_bmr.isChecked && weight_bmr.text.toString() != "" && height_bmr.text.toString() != "" && age_bmr.text.toString() != "") {
            bmrw = weight_bmr.text.toString()
            bmrWeigth = bmrw.toDouble()
            bmrh = height_bmr.text.toString()
            bmrHeight = bmrh.toDouble()
            bmrAge = Integer.parseInt(age_bmr.text.toString())
            bmrResult = (9.99 * bmrWeigth) + (6.25 * bmrHeight) - (5.92 * bmrAge) + 5
            bmr_result.text = bmrResult.toString()
        }
    }
}