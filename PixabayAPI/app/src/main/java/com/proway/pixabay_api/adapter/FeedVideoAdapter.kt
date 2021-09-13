package com.proway.pixabay_api.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pixabay_api.R
import com.proway.pixabay_api.databinding.FeedVideoItemBinding
import com.proway.pixabay_api.model.VideoConfig

private const val NORMAL_VIEW = 0
private const val ADS_VIEW = 1

class FeedVideoAdapter : ListAdapter<VideoConfig, RecyclerView.ViewHolder>(VideosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == ADS_VIEW)
            LayoutInflater.from(parent.context).inflate(R.layout.ads_item, parent, false).apply {
                return AdsViewHolder(this)
            }
        LayoutInflater.from(parent.context).inflate(R.layout.feed_video_item, parent, false).apply {
            return FeedVideoViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == NORMAL_VIEW) {
            holder as FeedVideoViewHolder
            getItem(position).let { video ->
                holder.bind(video)
            }
        }
        else
            holder as AdsViewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0 && position != 0) ADS_VIEW else NORMAL_VIEW
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

