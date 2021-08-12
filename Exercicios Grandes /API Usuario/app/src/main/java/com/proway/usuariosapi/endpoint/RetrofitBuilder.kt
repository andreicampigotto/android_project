package com.proway.usuariosapi.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val baseUrl = "https://fakestoreapi.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthenticationService(): Authenticaton{
        return retrofit.create(Authenticaton::class.java)
    }

    fun getProductServices(): ProductService {
        return retrofit.create(ProductService::class.java)
    }
}

