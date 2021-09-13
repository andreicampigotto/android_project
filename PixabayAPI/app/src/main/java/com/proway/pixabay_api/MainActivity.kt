package com.proway.pixabay_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.pixabay_api.databinding.MainActivityBinding
import com.proway.pixabay_api.view.FeedFragment
import com.proway.pixabay_api.view.FeedType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.toggleButtonGroup.check(R.id.buttonImage)
        binding.toggleButtonGroup.addOnButtonCheckedListener {
                group, checkedId, isChecked ->
            when(checkedId) {
                R.id.buttonImage -> replaceFrag(FeedType.IMAGE)
                R.id.buttonVideos -> replaceFrag(FeedType.VIDEO)
            }
        }
        replaceFrag(FeedType.IMAGE)
    }

    fun replaceFrag(feedType: FeedType) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FeedFragment(feedType)).commitNow()
    }
}