package com.proway.pixabay_api.repository

import com.proway.pixabay_api.model.Image
import com.proway.pixabay_api.model.VideoConfig
import com.proway.pixabay_api.service.PixabayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PixabayRepository @Inject constructor(private val service: PixabayApi) {

    suspend fun fetchImages(q: String): List<Image>? {
        return withContext(Dispatchers.Default) {
            val response = service.fetchImage(q = q)
            val processedResponse = processData(response)
            processedResponse?.hits
        }
    }

    suspend fun fetchVideos(q: String): List<VideoConfig>? {
        return withContext(Dispatchers.Default) {
            val response = service.fetchVideos(q = q)
            val processedResponse = processData(response)
            processedResponse?.hits
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}