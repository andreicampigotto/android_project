package com.proway.pixabay_api.adapter

import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pixabay_api.databinding.FeedVideoItemBinding
import com.proway.pixabay_api.model.VideoConfig

class FeedVideoAdapter: ListAdapter<VideoConfig, FeedVideoViewHolder>(VideosDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedVideoViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FeedVideoViewHolder, position: Int) {
        getItem(position).let{ video ->
            holder.bind(video)
        }
    }
}

class FeedVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: FeedVideoItemBinding = FeedVideoItemBinding.bind(itemView)

    fun bind(video: VideoConfig) {
        binding.textViewVideo.text = video.user
        Glide.with(itemView).load(video.userImageURL).into(binding.imageAvatar)
        binding.videoViewVideo.setVideoURI(Uri.parse(video.videos.medium.url))
        binding.videoViewVideo.start()
        binding.videoViewVideo.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
            val screenRatio = binding.videoViewVideo.width / binding.videoViewVideo.height.toFloat()
            val scaleX = videoRatio / screenRatio
            if (scaleX >= 1f) {
                binding.videoViewVideo.scaleX = scaleX
            } else {
                binding.videoViewVideo.scaleY = 1f / scaleX
            }
        }
    }
}

