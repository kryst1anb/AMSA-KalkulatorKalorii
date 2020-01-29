package com.example.kalkulatorkalorii.ui.BMI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class BMIFragment : Fragment() {

    private lateinit var BMIViewModel: BMIViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        BMIViewModel =
            ViewModelProviders.of(this).get(BMIViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_BMI, container, false)
        val textView: TextView = root.findViewById(R.id.)
        BMIViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}