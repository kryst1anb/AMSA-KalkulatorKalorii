package com.example.kalkulatorkalorii.ui.BMR

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class BMRFragment : Fragment() {

    private lateinit var BMRViewModel: BMRViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        BMRViewModel =
            ViewModelProviders.of(this).get(BMRViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_BMR, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        BMRViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}