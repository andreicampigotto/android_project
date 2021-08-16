package com.proway.mvvm_productrepository.services

import com.proway.mvvm_productrepository.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {

    @GET("/products")
    fun getProducts(): Call<List<Product>>

}