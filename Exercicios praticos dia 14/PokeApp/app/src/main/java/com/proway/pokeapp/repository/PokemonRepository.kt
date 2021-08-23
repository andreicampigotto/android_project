package com.proway.pokeapp.repository

import com.proway.pokeapp.model.PokeResponse
import com.proway.pokeapp.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    fun fetchAll(onComplete: (PokeResponse?, String?) -> Unit) {
        val service = RetrofitService.getPokeService()
        val call = service.getAll()
        call.enqueue(object : Callback<PokeResponse> {
            override fun onResponse(call: Call<PokeResponse>, response: Response<PokeResponse>) {
                if (response.body() != null)
                    onComplete(response.body(), null)
                else
                    onComplete(null, "Nenhum pokemon encontrado")
            }

            override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                onComplete(null, t.message)

            }
        })
    }
}