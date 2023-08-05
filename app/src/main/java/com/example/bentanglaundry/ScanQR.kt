package com.example.bentanglaundry

import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.budiyev.android.codescanner.*
import com.example.bentanglaundry.databinding.ActivityScanQrBinding
import okhttp3.internal.http2.Http2Connection

class ScanQR : AppCompatActivity() {

    lateinit var binding: ActivityScanQrBinding
    lateinit var codeScanQR : CodeScanner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listview = findViewById<ListView>(R.id.listView);
        var hasilscanner = findViewById<TextView>(R.id.hasilscanner)

        hasilscanner(hasilscanner)

        codeScanQR()
        setPermission()


    }

    private fun hasilscanner(hasilscanner: TextView?) {
        var Hasil = hasilscanner.toString()
        if(Hasil.equals("")){
            Toast.makeText(this, "ID Pelanggan Salah", Toast.LENGTH_SHORT).show();
        } else {

        }
    }


    private fun codeScanQR() {
        codeScanQR = CodeScanner(this, binding.scanner)

        codeScanQR.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = true

            decodeCallback = DecodeCallback {
                runOnUiThread{
                    binding.hasilscanner.text = it.text
                }
            }

            errorCallback = ErrorCallback {
                runOnUiThread {
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }

            binding.scanner.setOnClickListener {
                codeScanQR.startPreview()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        codeScanQR.startPreview()
    }

    override fun onPause() {
        super.onPause()
        codeScanQR.startPreview()
    }

    private fun setPermission() {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        if(permission != PackageManager.PERMISSION_GRANTED){
            makeReq()
        }
    }

    private fun makeReq() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CAMERA), 101
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            101 -> {
                if (grantResults. isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Dibutuhkan", Toast.LENGTH_SHORT).show()
            }
        }
    }


}