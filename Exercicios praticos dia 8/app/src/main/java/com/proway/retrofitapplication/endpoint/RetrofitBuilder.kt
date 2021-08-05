package com.proway.retrofitapplication.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val baseUrl =  "https://parallelum.com.br"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServiceCarInstance(): ServiceCar{
        return RetrofitBuilder.retrofit.create(ServiceCar::class.java)
    }
}