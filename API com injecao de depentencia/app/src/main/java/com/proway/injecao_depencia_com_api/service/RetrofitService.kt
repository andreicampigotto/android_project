package com.proway.injecao_depencia_com_api.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService{

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUsers(): UserService = retrofit.create(UserService::class.java)
}