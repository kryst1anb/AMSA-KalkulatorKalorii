package com.example.kalkulatorkalorii.ui.Product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class ProductFragment : Fragment() {

    private lateinit var prodcutViewModel: ProdcutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prodcutViewModel =
            ViewModelProviders.of(this).get(ProdcutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_Product, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        prodcutViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}