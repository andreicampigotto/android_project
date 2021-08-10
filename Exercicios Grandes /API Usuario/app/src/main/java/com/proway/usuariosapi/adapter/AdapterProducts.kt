package com.proway.usuariosapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.usuariosapi.R
import com.proway.usuariosapi.model.Product


class AdapterProducts : RecyclerView.Adapter<ViewHolderItemProduct>() {

    private var listOfProducts = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemProduct {
        LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false).apply {
            return ViewHolderItemProduct(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolderItemProduct, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfProducts.size

    fun update(newList: List<Product>) {
        listOfProducts = mutableListOf()
        listOfProducts.addAll(newList)
        notifyDataSetChanged()
    }
}

class ViewHolderItemProduct(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val productImageView: ImageView = itemView.findViewById(R.id.imageViewProduct)
    private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
    private val subtitleTextView: TextView = itemView.findViewById(R.id.textViewSubTitle)
    private val priceTextView: TextView = itemView.findViewById(R.id.textViewPrice)

    fun bind(product: Product) {
        titleTextView.text = product.title
        subtitleTextView.text = product.description

        priceTextView.text = "R$ ${product.price}"

        Glide.with(itemView.context)
            .load(product.image)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(productImageView)

    }
}
