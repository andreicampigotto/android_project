package com.proway.genericadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.genericadapter.R
import com.proway.genericadapter.TipoLista
import com.proway.genericadapter.model.Car
import com.proway.genericadapter.model.Product

class GenericAdapter<T>(private val listOf: MutableList<T>, private val type : TipoLista) :
    RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val viewProduct = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        val viewCar = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        val finalView = if (type == TipoLista.PRODUTOS) viewProduct else viewCar
        return GenericViewHolder(finalView)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOf.size
}

class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val subTitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)

    fun <T> bind(model: T) {
        when (model) {
            is Product -> {
                titleTextView.text = model.id.toString()
                subTitleTextView.text = model.nome
            }
            is Car -> {
                titleTextView.text = model.modelo
                subTitleTextView.text = model.ano.toString()

               val tipoCombustivel: TextView = itemView.findViewById(R.id.tipoCombustivel)

                tipoCombustivel.text = model.combustivel
            }
        }
    }
}