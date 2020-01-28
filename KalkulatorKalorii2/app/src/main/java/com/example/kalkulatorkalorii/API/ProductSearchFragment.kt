package com.example.kalkulatorkalorii.API

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulatorkalorii.Adapters.SearchListAdapter
import com.example.kalkulatorkalorii.R
import kotlinx.android.synthetic.main.fragment_kcal.*

class ProductSearchFragment:Fragment() {
    private lateinit var searchViewModel: ProductSearchViewModel
    private lateinit var adapter: SearchListAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        searchViewModel = ProductSearchViewModel()
        return inflater.inflate(R.layout.fragment_kcal, container, false)
    }

    override fun onStart() {
        super.onStart()

        button_search_item.setOnClickListener {
            val response = searchViewModel.apiConnection(name_kcal?.text.toString())
            adapter = SearchListAdapter(response.listItems, requireContext(), this)
            recycler_search_list.adapter = adapter
            recycler_search_list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }
    }
}