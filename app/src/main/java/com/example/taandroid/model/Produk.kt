package com.example.taandroid.model

import java.io.Serializable

class Produk : Serializable{

    lateinit var id:String
    lateinit var produk:String
    lateinit var harga:String
    var gambar:Int = 0

}