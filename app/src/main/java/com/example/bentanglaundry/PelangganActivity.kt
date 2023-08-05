package com.example.bentanglaundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bentanglaundry.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PelangganActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelanggan)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val HomeFragment = HomeFragment()
        val HistoryFragment = HistoryFragment()

        setFragment(HomeFragment)

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> {setFragment(HomeFragment)}

                R.id.history -> {setFragment(HistoryFragment)}
            }
            true

        }

    }

    private fun setFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
}