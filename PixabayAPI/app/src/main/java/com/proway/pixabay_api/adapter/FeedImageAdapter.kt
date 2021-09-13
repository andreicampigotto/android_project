package com.proway.pixabay_api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pixabay_api.R
import com.proway.pixabay_api.databinding.FeedImageItemBinding
import com.proway.pixabay_api.model.Image

private const val NORMAL_VIEW = 0
private const val ADS_VIEW = 1

class FeedImageAdapter : ListAdapter<Image, RecyclerView.ViewHolder>(ImagesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ADS_VIEW) {
            LayoutInflater.from(parent.context).inflate(R.layout.ads_item, parent, false)
                .apply {
                    return AdsViewHolder(this)
                }
        }
        LayoutInflater.from(parent.context).inflate(R.layout.feed_image_item, parent, false).apply {
            return FeedImageViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == NORMAL_VIEW) {
            holder as FeedImageViewHolder
            getItem(position).let { image ->
                holder.bind(image)
            }
        } else
            holder as AdsViewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0 && position != 0) ADS_VIEW else NORMAL_VIEW
    }
}

class FeedImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: FeedImageItemBinding = FeedImageItemBinding.bind(itemView)

    fun bind(image: Image) {
        binding.textViewImage.text = image.user
        Glide.with(itemView).load(image.largeImageURL).into(binding.imageViewImage)
        Glide.with(itemView).load(image.userImageURL).into(binding.imageAvatar)
    }
}