package com.example.bentanglaundry



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {

    fun Home() {

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        SavedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonscan: Button = view.findViewById(R.id.online_trans) as Button
        buttonscan.setOnClickListener {
                val scanintent = Intent(activity, ScanQR::class.java)
                startActivity(scanintent)
        }

        return view
    }


}