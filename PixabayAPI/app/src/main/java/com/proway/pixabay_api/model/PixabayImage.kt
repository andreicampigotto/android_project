package com.proway.pixabay_api.model

import com.google.gson.annotations.SerializedName

data class PixabayImage(
    @SerializedName("total")
    val total: Int,
    @SerializedName("hits")
    val hits: List<Image>
)

data class Image(
    val id: Int,
    val tags: String,
    val previewURL: String,
    val largeImageURL: String,
    val fullHDURL: String,
    val imageURL: String,
    val user: String,
    val userImageURL: String,
)