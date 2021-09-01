package com.proway.crud_firebills.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crud_firebills.R
import com.proway.crud_firebills.databinding.CategoryCrudFragmentBinding
import com.proway.crud_firebills.databinding.CategoryItemBinding
import com.proway.crud_firebills.model.Category

class BillsAdapter : RecyclerView.Adapter<BillsViewHolder>() {

    private var categories = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillsViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false).apply {
            return BillsViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: BillsViewHolder, position: Int) {
        categories[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = categories.size
}

class BillsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private var binding: CategoryItemBinding = CategoryItemBinding.bind(itemView)

    fun bind(category: Category){
        binding.tvIdItemCategory.text = "#${category.id}"
        binding.tcNameItemCategory.text = category.name
    }
}