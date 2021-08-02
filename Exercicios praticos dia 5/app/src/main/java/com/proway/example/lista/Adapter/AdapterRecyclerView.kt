package com.proway.example.lista.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.lista.R
import com.proway.example.lista.model.Car

class AdapterRecyclerView(
    val listOfCars: List<Car>
) : RecyclerView.Adapter<ItemCarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ItemCarViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemCarViewHolder, position: Int) {
        listOfCars[position].apply {
            viewHolder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfCars.size
    }
}

class ItemCarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(car: Car){

        itemView.findViewById<TextView>(R.id.textViewMarca).apply {
            text = car.marca
        }

        itemView.findViewById<TextView>(R.id.textViewModelo).apply {
            text = car.modelo
        }

        itemView.findViewById<TextView>(R.id.textViewAno).apply {
            text = car.ano.toString()
        }
    }
}