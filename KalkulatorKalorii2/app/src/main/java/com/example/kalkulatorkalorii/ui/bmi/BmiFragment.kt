package com.example.kalkulatorkalorii.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class BmiFragment : Fragment() {

    private lateinit var BmiViewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        BmiViewModel =
            ViewModelProviders.of(this).get(BmiViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bmi, container, false)
        val textView: TextView = root.findViewById(R.id.text_bmi)
        BmiViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}