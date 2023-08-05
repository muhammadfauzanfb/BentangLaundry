package com.example.bentanglaundry.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bentanglaundry.R
import com.example.bentanglaundry.databinding.ListHistoryBinding


class HistoryAdapter(val results : ArrayList<HistoryModel.Result>)
    : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val result = results[position]
            binding.namaPelangganHistory.text = result.nama_pelanggan
            binding.jenisLaundryHistory.text = result.jenis_laundry
            binding.totalTransaksiHistory.text = result.totalbayar.toString()
            binding.statusPencucianHistory.text = result.status_pencucian.toString()

        }
    }

    override fun getItemCount() = results.size

    class ViewHolder(val binding: ListHistoryBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(data: List<HistoryModel.Result>){
        results.clear()
        results.addAll( data )
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(result: HistoryModel.Result)
    }
}