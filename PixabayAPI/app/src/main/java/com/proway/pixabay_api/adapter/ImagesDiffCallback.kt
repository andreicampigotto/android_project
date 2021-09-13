package com.proway.pixabay_api.adapter

import androidx.recyclerview.widget.DiffUtil
import com.proway.pixabay_api.model.Image

class ImagesDiffCallback : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }
}