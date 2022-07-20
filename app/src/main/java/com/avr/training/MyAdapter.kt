package com.avr.training

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listData: MutableList<String>, private val context: Context): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_holder, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(listData.size > position) {
            holder.bind(listData[position])
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: String){
        itemView.findViewById<TextView>(R.id.list_item).text = item
    }
}
