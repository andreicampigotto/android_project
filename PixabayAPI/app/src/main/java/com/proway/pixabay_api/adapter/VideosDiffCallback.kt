package com.proway.pixabay_api.adapter

import androidx.recyclerview.widget.DiffUtil
import com.proway.pixabay_api.model.VideoConfig

class VideosDiffCallback : DiffUtil.ItemCallback<VideoConfig>() {
    override fun areItemsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem.id == newItem.id
    }
}