package com.proway.projectfragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.projectfragments.QualquerCoisaLista
import com.proway.projectfragments.R

class ExemploAdapter(val listaExemplo: MutableList<QualquerCoisaLista>) :
    RecyclerView.Adapter<ExemploViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExemploViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exemplo, parent, false)
        return ExemploViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExemploViewHolder, position: Int) {
        listaExemplo[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listaExemplo.size
}


class ExemploViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.titleTextView)
    private val subTitle: TextView = itemView.findViewById(R.id.subtitleTextView)

    fun bind(example: QualquerCoisaLista) {
        title.text = example.nome
        subTitle.text = example.descricao
    }
}