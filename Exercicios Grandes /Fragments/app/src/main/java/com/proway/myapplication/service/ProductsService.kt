package com.proway.myapplication.service

import com.proway.myapplication.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {
    @GET("/products")
    fun getProducts(): Call<List<Product>>
}