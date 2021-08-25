package com.proway.pokeapp.model

import androidx.annotation.ColorInt
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.proway.pokeapp.R

@Entity
data class PokeDetails(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "detail_id")
    val id: Int,

    @Embedded
    @SerializedName("sprites")
    val sprites: Sprites?,

    @SerializedName("types")
    val type: List<Types>
)
@Entity
data class Sprites(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sprites_id")
    val id: Int,

    @Embedded
    @SerializedName("other")
    val other: Other?
)
@Entity
data class Other(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "other_id")
    val id: Int,

    @Embedded
    @SerializedName("official-artwork")
    val artWork: ArtWork?
)
@Entity
data class ArtWork(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artwork_id")
    val id: Int,

    @SerializedName("front_default")
    val image: String?
)

@Entity
data class Types(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "types_pokemon_id")
    val id: Int,

    @SerializedName("slot")
    val slot: String,

    @Embedded
    @SerializedName("type")
    val type: PokemonType,
)

@Entity
data class PokemonType(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pokemon_type_name")
    val id: Int,

    @SerializedName("name")
    val typeName: String,

    @ColumnInfo(name = "pokemon_type_url")
    @SerializedName("url")
    val typeUrl: String
){

    fun extractBgColor(): Int {
        return when (typeName) {
            "bug" -> R.color.bg_type_bug
            "water" -> R.color.bg_type_water
            "fairy" -> R.color.bg_type_fairy
            "ghost" -> R.color.bg_type_ghost
            "normal" -> R.color.bg_type_normal
            "dark" -> R.color.bg_type_dark
            "figthing" -> R.color.bg_type_figthing
            "grass" -> R.color.bg_type_grass
            "poison" -> R.color.bg_type_poison
            "dragon" -> R.color.bg_type_dragon
            "fire" -> R.color.bg_type_fire
            "ground" -> R.color.bg_type_ground
            "psychic" -> R.color.bg_type_psychic
            "eletric" -> R.color.bg_type_eletric
            "flying" -> R.color.bg_type_flying
            "ice" -> R.color.bg_type_ice
            "rock" -> R.color.bg_type_rock
            else -> R.color.bg_type_normal
        }
    }
}

enum class PokeTypeSetup(val bgColor: Int, val typeColor: Int, val typeIcon: Int, val  nameType: String){
    NORMAL(R.color.bg_type_normal, R.color.type_normal, R.drawable.normal, "Normal"),
    ROCK(R.color.bg_type_rock, R.color.type_rock, R.drawable.rock, "Rock"),
    ICE(R.color.bg_type_ice, R.color.type_ice, R.drawable.ice, "Ice"),
    FLYING(R.color.bg_type_flying, R.color.type_flying, R.drawable.flying, "Flying"),
    ELETRIC(R.color.bg_type_eletric, R.color.bg_type_eletric, R.drawable.electric, "Eletric"),
    PSYCHIC(R.color.bg_type_psychic, R.color.type_psychic, R.drawable.psychic, "Psychic"),
    GROUND(R.color.bg_type_ground, R.color.type_ground, R.drawable.ground, "Ground"),
    FIRE(R.color.bg_type_fire, R.color.type_fire, R.drawable.fire, "Fire"),
    DRAGON(R.color.bg_type_dragon, R.color.type_dragon, R.drawable.dragon, "Dragon"),
    POISON(R.color.bg_type_poison, R.color.type_poison, R.drawable.poison, "Poison"),
    GRASS(R.color.bg_type_grass, R.color.type_grass, R.drawable.grass, "Grass"),
    FIGTHING(R.color.bg_type_figthing, R.color.type_fighting, R.drawable.fighting, "Figthing"),
    DARK(R.color.bg_type_dark, R.color.type_dark, R.drawable.dark, "Dark"),
    GHOST(R.color.bg_type_ghost, R.color.type_ghost, R.drawable.ghost, "Ghost"),
    FAIRY(R.color.bg_type_fairy, R.color.type_fairy, R.drawable.fairy, "Fairy"),
    WATER(R.color.bg_type_water, R.color.type_water, R.drawable.water, "Water"),
    BUG(R.color.bg_type_bug, R.color.type_bug, R.drawable.bug, "Bug"),
}

