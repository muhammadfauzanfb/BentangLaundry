package com.example.bentanglaundry.retrofit

import com.example.bentanglaundry.history.HistoryModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("detailtransaksi.php")
    fun getDetail(): Call<HistoryModel>
}