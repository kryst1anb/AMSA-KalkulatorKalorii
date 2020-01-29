package com.example.kalkulator.adapter

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.db.Product
import com.example.kalkulator.db.ProductDB
import com.example.kalkulatorkalorii.R
import kotlinx.android.synthetic.main.list_product.view.*

class YourProductsAdapter(val products: List<Product>, val context: Context, val fragment: Fragment) : RecyclerView.Adapter<YourProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_product,parent,false)
        return ViewHolder(v)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]
        holder.item_name.text = product.name
    }


class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    val item_name = itemView.findViewById<TextView>(R.id.item_name)
    val nf_calories = itemView.findViewById<TextView>(R.id.item_kcal)
    val nf_total_fat = itemView.findViewById<TextView>(R.id.item_fat)
    val nf_protein = itemView.findViewById<TextView>(R.id.item_protein)
    val nf_total_carbohydrate = itemView.findViewById<TextView>(R.id.item_carbo)
    val buttonDelProduct = itemView.findViewById<Button>(R.id.delete_item)
    val oneItem = itemView.findViewById<LinearLayout>(R.id.one_item)
}

    override fun getItemCount(): Int {
        return products.size
    }
}