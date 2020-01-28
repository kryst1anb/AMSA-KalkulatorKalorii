package com.example.kalkulatorkalorii.ui.demand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class DemandFragment : Fragment() {

    private lateinit var demandViewModel: DemandViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        demandViewModel =
            ViewModelProviders.of(this).get(DemandViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_demand, container, false)
        val textView: TextView = root.findViewById(R.id.text_demand)
        demandViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}