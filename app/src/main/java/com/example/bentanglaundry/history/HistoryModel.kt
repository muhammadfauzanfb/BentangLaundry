package com.example.bentanglaundry.history

data class HistoryModel (val result: ArrayList<Result> ) {
    data class Result (val nama_pelanggan:String, val jenis_laundry:String, val totalbayar:Int, val tgl_terima:Int, val status_pencucian:Int)

}