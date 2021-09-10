package com.proway.pixabay_api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pixabay_api.R
import com.proway.pixabay_api.databinding.FeedItemBinding
import com.proway.pixabay_api.model.Image

class FeedImageAdapter: ListAdapter<Image, FeedViewHolder>(ImagesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false).apply {
            return FeedViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        getItem(position).let { image ->  
            holder.bind(image)
        }
    }
}

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val binding : FeedItemBinding = FeedItemBinding.bind(itemView)

    fun bind(image:Image){
        binding.textViewImage.text = image.user
        Glide.with(itemView).load(image.largeImageURL).into(binding.imageViewImage)
        Glide.with(itemView).load(image.userImageURL).into(binding.imageAvatar)
    }
}