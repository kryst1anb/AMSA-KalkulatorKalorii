package com.example.kalkulatorkalorii.ui;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kalkulatorkalorii.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("About")
        setContentView(R.layout.activity_about)
    }
}