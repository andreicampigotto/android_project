package com.proway.pokeapp.database.dao

import androidx.room.*
import com.proway.pokeapp.model.Pokemon
import com.proway.pokeapp.model.Types

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM Pokemon ORDER BY poke_name")
    fun all(): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE poke_name = :idPoke")
    fun getById(idPoke: String): Pokemon?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: Pokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertType(types: List<Types>)

    @Query("SELECT * FROM pokemon WHERE poke_name LIKE '%' || :query || '%'")
    fun fetchFiltered(query: String) : List<Pokemon>
}