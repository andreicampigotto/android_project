package com.proway.pokeapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co")
        .addConverterFactory((GsonConverterFactory.create()))
        .build()

    fun getPokeService(): PokeService{
        return retrofit.create(PokeService::class.java)
    }
}