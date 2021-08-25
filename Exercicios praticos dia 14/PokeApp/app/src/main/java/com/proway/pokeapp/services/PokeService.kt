package com.proway.pokeapp.services

import com.proway.pokeapp.model.PokeDetails
import com.proway.pokeapp.model.PokeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("/api/v2/pokemon?limit=1118")
    fun getAll(): Call<PokeResponse>

    @GET("/api/v2/pokemon/{id}")
    fun getDetails(@Path("id") id: String): Call<PokeDetails>
}