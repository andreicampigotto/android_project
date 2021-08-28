package com.proway.crud_firebills.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crud_firebills.R
import com.proway.crud_firebills.databinding.CategoryItemBinding
import com.proway.crud_firebills.model.Category

class CategoryAdapter(val onTap: (Category) -> Unit): RecyclerView.Adapter<BillsViewHolder>() {

    private var listOf = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BillsViewHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false).let {
            return BillsViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: BillsViewHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onTap(this)
            }
        }
    }

    override fun getItemCount(): Int = listOf.size

    fun refresh(newList: List<Category>) {
        listOf = mutableListOf()
        listOf.addAll(newList)
        notifyDataSetChanged()
    }
}

class BillsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private var binding: CategoryItemBinding = CategoryItemBinding.bind(itemView)

    fun bind(category: Category){
        binding.tvIdItemCategory.text = "#${category.id}"
        binding.tcNameItemCategory.text = category.name
    }
}