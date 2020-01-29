package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R

class FragmentContainerSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_container_search)

        val fragmentMainList = ProductSearchFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerSearch,fragmentMainList).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_kalorie -> openFragmentContainerSearch()
            R.id.action_products -> openFragmentContainerList()
        }

        return super.onOptionsItemSelected(item)
    }

    fun openFragmentContainerSearch()
    {
        val intent = Intent(this,
            FragmentContainerSearch::class.java)
        startActivity(intent)
    }

    fun openFragmentContainerList()
    {
        val intent = Intent(this, FragmentContainerList::class.java)
        startActivity(intent)
    }
}