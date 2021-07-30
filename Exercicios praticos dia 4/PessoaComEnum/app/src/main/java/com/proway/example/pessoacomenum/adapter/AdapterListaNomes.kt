package com.proway.example.pessoacomenum.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.pessoacomenum.R

class AdapterListaNomes(val arrayDeNomes: ArrayList<String>) : RecyclerView.Adapter<ViewHolderNomes>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNomes {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_nome, parent, false)
            return ViewHolderNomes(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNomes, position: Int) {
        holder.textViewNome.text = arrayDeNomes[position]
    }

    override fun getItemCount(): Int {
        return arrayDeNomes.size
    }


}

class ViewHolderNomes(itemView: View) : RecyclerView.ViewHolder(itemView){
    val textViewNome: TextView = itemView.findViewById(R.id.nameTextView)
}