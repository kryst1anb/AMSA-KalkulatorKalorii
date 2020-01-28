package com.example.kalkulatorkalorii.ui.kcal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.kalkulatorkalorii.R

class KcalFragment : Fragment() {

    private lateinit var kcalViewModel: KcalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kcalViewModel =
            ViewModelProviders.of(this).get(KcalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_kcal, container, false)

        /*val textView: TextView = root.findViewById(R.id.text_kcal)

        kcalViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        return root
    }
}