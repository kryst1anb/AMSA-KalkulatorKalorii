package com.example.kalkulatorkalorii.ui.bmr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class BmrFragment : Fragment() {

    private lateinit var bmrViewModel: BmrViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bmrViewModel =
            ViewModelProviders.of(this).get(BmrViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bmr, container, false)
        val textView: TextView = root.findViewById(R.id.text_sex_bmr)
        bmrViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}