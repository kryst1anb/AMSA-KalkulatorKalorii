package com.example.kalkulator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.adapter.SearchingListAdapter
import com.example.kalkulator.api.apiConnect
import kotlinx.android.synthetic.main.fragment_kcal.*

class ProductSearchFragment : Fragment() {

    private  lateinit var adapter : SearchingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater?.inflate(R.layout.fragment_kcal,container,false)
        val searchButton = view.findViewById<Button>(R.id.button_search_item)

        searchButton.setOnClickListener()
        {
            productSearch()
        }
        return view
    }

    private fun productSearch()
    {
        val name : String = view?.findViewById<EditText>(R.id.name_product_search)?.text.toString()

        val data : Bundle = Bundle()

        data.putString("name",name)

        val listFragment = ProductSearchFragment()

        listFragment.arguments = data
        var Act : FragmentContainerSearch = getContext() as FragmentContainerSearch

        Act.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerSearch,listFragment).addToBackStack(null).commit()
    }

    override fun onStart() {
        super.onStart()

        button_search_item.setOnClickListener {
            val response = apiConnect().apiConnection((name_product_search?.text.toString()))
            adapter = SearchingListAdapter(response.listItems,requireContext(),this)
            search_list.adapter = adapter
            search_list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }
    }
}