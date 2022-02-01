package com.example.taandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taandroid.R
import com.example.taandroid.model.Produk
import org.w3c.dom.Text

class AdapterProduk(var data:ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {

    class Holder(view:View):RecyclerView.ViewHolder(view){

        val tv_idproduk = view.findViewById<TextView>(R.id.tv_idproduk)
        val tv_produk = view.findViewById<TextView>(R.id.tv_produk)
        val tv_harga = view.findViewById<TextView>(R.id.tv_harga)
        val img_produk = view.findViewById<ImageView>(R.id.img_produk)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return  Holder(view)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.tv_idproduk.text = data[position].id
        holder.tv_produk.text = data[position].produk
        holder.tv_harga.text = data[position].harga
        holder.img_produk.setImageResource(data[position].gambar)

    }

    override fun getItemCount(): Int {

        return data.size

    }

}