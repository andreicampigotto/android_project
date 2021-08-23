package com.proway.pokeapp.database.dao

import androidx.room.*
import com.proway.pokeapp.model.Pokemon

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM Pokemon ORDER BY poke_name")
    fun all(): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE poke_name = :idPoke")
    fun getById(idPoke: String): Pokemon?

    @Insert
    fun insert(pokemon: Pokemon)
}