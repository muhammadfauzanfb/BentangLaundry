package com.example.bentanglaundry


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bentanglaundry.history.HistoryAdapter
import com.example.bentanglaundry.history.HistoryModel
import com.example.bentanglaundry.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment : Fragment() {
    private val TAG:String = "History"

    lateinit var  historyAdapter: HistoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
        setupRecylerView()

    }

    private fun setupRecylerView() {
        val recyclerhistory = findViewById<RecyclerView>(R.id.history_recycleview)
        historyAdapter = HistoryAdapter(arrayListOf(), object : HistoryAdapter.OnAdapterListener {
            override fun onClick(result: HistoryModel.Result) {
                startActivity(
                    Intent(this@HistoryFragment, DetailHistory::class.java)
                        .putExtra("intent_nama_pelanggan", result.nama_pelanggan)
                        .putExtra("intent_tgl_terima", result.tgl_terima)
                        .putExtra("intent_status_pencucian", result.status_pencucian)
                        .putExtra("intent_jenis_laundry", result.jenis_laundry)
                        .putExtra("intent_totalbayar", result.totalbayar)

                )
            }
        })
        recyclerhistory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
        }
    }
    private fun getDataFromApi(){
        ApiService.endpoint.getDetail()
            .enqueue(object : Callback<HistoryModel> {

                override fun onResponse(
                    call: Call<HistoryModel>,
                    response: Response<HistoryModel>
                ) {
                    if (response.isSuccessful){
                        showDetail(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<HistoryModel>, t: Throwable) {
                    printlog(t.toString())
                }

            })
    }

    private fun printlog(message: String){
        Log.d(TAG, message)
    }

    private fun showDetail(data: HistoryModel) {
        val results = data.result
        for (result in results) {
            printlog("Nama: ${result.nama_pelanggan}")
        }
    }

}