package com.proway.retrofitapplication.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.retrofitapplication.R
import com.proway.retrofitapplication.model.Marca

class AdapterMarcas(

    val listOfMarcas: MutableList<Marca>

) : RecyclerView.Adapter<ViewHolderItemMarca>() {

    private var listOfBrands: MutableList<Marca> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemMarca {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderItemMarca, position: Int) {
        listOfBrands[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfBrands.size
    }

    fun update(newList: List<Marca>) {
        listOfBrands = mutableListOf()
        listOfBrands.addAll(newList)
        notifyDataSetChanged()
    }

}

class ViewHolderItemMarca(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val codeTextView = itemView.findViewById<TextView>(R.id.codeTextView)
    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)

    fun bind(marca: Marca){
        codeTextView.text = marca.id
        nameTextView.text = marca.name
    }
}