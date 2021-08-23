package com.proway.pokeapp.services

import com.proway.pokeapp.model.PokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokeService {

    @GET("/api/v2/pokemon/")
    fun getAll(): Call<PokeResponse>
}