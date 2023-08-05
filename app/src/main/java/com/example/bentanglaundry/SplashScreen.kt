package com.example.bentanglaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val getstarted = findViewById<Button>(R.id.getstarted)

        getstarted.setOnClickListener(){
            val intent = Intent(this, PelangganActivity::class.java)
            startActivity(intent)
        }
    }
}