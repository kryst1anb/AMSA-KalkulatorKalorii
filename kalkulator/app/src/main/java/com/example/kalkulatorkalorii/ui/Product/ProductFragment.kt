package com.example.kalkulatorkalorii.ui.Product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulatorkalorii.adapter.SearchingListAdapter
import com.example.kalkulatorkalorii.json.ResultProduct
import com.example.kalkulatorkalorii.R
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var adapter: SearchingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        productViewModel = ProductViewModel()
        return inflater.inflate(R.layout.fragment_product, container, false)

    }

    override fun onStart() {
        super.onStart()

        button_search_item.setOnClickListener {
            if (name_product_search?.text.toString() != "") {
                var list = mutableListOf<ResultProduct>()
                val product1 = ResultProduct("item1", 33.4, 29.4, 10.0, 14.7, 100)
                val product2 = ResultProduct("item2", 32.1, 87.4, 13.0, 16.6, 100)
                list.add(product1)
                list.add(product2)

                adapter = SearchingListAdapter(list, requireContext(), this)
                search_list.adapter = adapter
                search_list.layoutManager = LinearLayoutManager(
                    activity,
                    RecyclerView.VERTICAL, false
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Proszę wpisać nazwę przedmiotu!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}