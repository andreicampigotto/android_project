package com.proway.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.myapplication.R
import com.proway.myapplication.model.Product

class ProductAdapter(val onClick:(Product)-> Unit):RecyclerView.Adapter<ProductViewHolder>() {

    private var listOfProducts = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_lista_produtos, parent, false).apply {
            return ProductViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener { onClick(this) }
        }
    }

    override fun getItemCount(): Int = listOfProducts.size

    fun update(newList: List<Product>){
        listOfProducts = mutableListOf()
        listOfProducts.addAll(newList)
        notifyDataSetChanged()
    }

}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)
    private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)

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