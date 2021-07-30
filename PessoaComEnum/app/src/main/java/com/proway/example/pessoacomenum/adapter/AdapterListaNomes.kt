package com.proway.example.pessoacomenum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.pessoacomenum.R

class AdapterListaNomes : RecyclerView.Adapter<ViewHolderNomes>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNomes {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_nome, false)
            return ViewHolderNomes(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNomes, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

class ViewHolderNomes(itemView: View) : RecyclerView.ViewHolder(itemView){

}