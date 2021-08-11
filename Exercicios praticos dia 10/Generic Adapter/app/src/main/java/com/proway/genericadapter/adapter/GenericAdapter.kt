package com.proway.genericadapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T>(private val listOf: MutableList<T>) :
    RecyclerView.Adapter<GenericViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {

    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        listOf[position].apply {
            //holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOf.size


}

class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


}