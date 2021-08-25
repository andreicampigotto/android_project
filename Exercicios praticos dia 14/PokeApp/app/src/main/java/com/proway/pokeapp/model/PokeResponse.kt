package com.proway.pokeapp.model

import androidx.room.*
import com.google.gson.annotations.SerializedName

data class PokeResponse(
    val results: List<Pokemon>
)

@Entity
data class Pokemon(
    @PrimaryKey
    @ColumnInfo(name = "poke_name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "poke_url")
    @SerializedName("url")
    val url: String,

    @Embedded
    var details: PokeDetails

){
    fun extractIdFromUrl(withPads: Boolean = false):String{
        val listStr = url.split("/")
        return if (withPads) listStr[6].padStart(3,'0') else listStr[6]
    }
}
