package com.example.kalkulator.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.MainActivity
import com.example.kalkulator.R
import com.example.kalkulator.db.Product
import com.example.kalkulatorkalorii.json.ResultProduct

class SearchingListAdapter(
    val products: List<ResultProduct?>?,
    val context: Context,
    val fragment: Fragment)
    : RecyclerView.Adapter<SearchingListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products!![position]!!
        holder.item_name.text = product.item_name
        holder.nf_calories.text = product.nf_calories.toString()
        holder.nf_total_fat.text = product.nf_total_fat.toString()
        holder.nf_protein.text = product.nf_protein.toString()
        holder.nf_total_carbohydrate.text = product.nf_total_carbohydrate.toString()

        holder.buttonAddProduct.setOnClickListener {
            //add to db
            Thread {
                val db = RecipeDatabase.getInstance(context)

                val insertRecipe = Product(null, product.item_name!!, product.nf_calories!!, product.nf_total_fat!!, product.nf_protein!!, product.nf_total_carbohydrate!!)
                db.recipeDao().insert(insertRecipe)

            }.start()
            Toast.makeText(context, "Recipe added", Toast.LENGTH_SHORT).show()
        }

        holder.singleRecipe.setOnClickListener {
            val intent = Intent(context, DisplaySearchRecipe::class.java).apply {
                putExtra("title", product.item_name)
                putExtra("ingredients", product.ingredients)
                putExtra("href", product.href)
            }
            (context as MainActivity).startActivity(intent)
        }
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val item_name = itemView.findViewById<TextView>(R.id.item_name)
        val nf_calories = itemView.findViewById<TextView>(R.id.item_kcal)
        val nf_total_fat = itemView.findViewById<TextView>(R.id.item_fat)
        val nf_protein = itemView.findViewById<TextView>(R.id.item_protein)
        val nf_total_carbohydrate = itemView.findViewById<TextView>(R.id.item_carbo)
        val buttonAddProduct = itemView.findViewById<Button>(R.id.add_item)
    }

    override fun getItemCount(): Int {
        return if (products == null) 0 else products.size
    }

}