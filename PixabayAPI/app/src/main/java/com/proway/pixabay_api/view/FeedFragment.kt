package com.proway.pixabay_api.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.pixabay_api.R
import com.proway.pixabay_api.adapter.FeedImageAdapter
import com.proway.pixabay_api.adapter.FeedVideoAdapter
import com.proway.pixabay_api.adapter.HeaderAdapter
import com.proway.pixabay_api.databinding.FeedFragmentBinding
import com.proway.pixabay_api.model.Image
import com.proway.pixabay_api.model.VideoConfig
import com.proway.pixabay_api.view_model.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment(private val feedType: FeedType) : Fragment(R.layout.feed_fragment) {

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding: FeedFragmentBinding
    lateinit var adapters: ConcatAdapter
    private val adapterImage = FeedImageAdapter()
    private val adapterVideo = FeedVideoAdapter()
    private val adapterHeader = HeaderAdapter {
        viewModel.fetchImages(it)
    }

    private val observerImages = Observer<List<Image>> {
        adapterImage.submitList(it)
    }

    private val observerVideos = Observer<List<VideoConfig>> {
        adapterVideo.submitList(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.images.observe(viewLifecycleOwner, observerImages)
        viewModel.videos.observe(viewLifecycleOwner, observerVideos)

        adapters = ConcatAdapter(
            adapterHeader,
            if (feedType == FeedType.VIDEO) adapterVideo else adapterImage,
        )

        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.recyclerViewFeed) {
        adapter = adapters
        layoutManager = LinearLayoutManager(requireContext())
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                hideSoftInput()
            }
        })
        if (feedType == FeedType.VIDEO) viewModel.fetchVideo() else viewModel.fetchImages()
    }
}

//o que essa func faz?
fun View.hideSoftInput() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

enum class FeedType {
    VIDEO,
    IMAGE
}