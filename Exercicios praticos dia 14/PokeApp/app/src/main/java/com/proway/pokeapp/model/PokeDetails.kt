package com.proway.pokeapp.model

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
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

    fun extractBgColor(): PokeTypeSetup {
        return when (typeName) {
            "bug" -> PokeTypeSetup.BUG
            "water" -> PokeTypeSetup.WATER
            "fairy" -> PokeTypeSetup.FAIRY
            "ghost" -> PokeTypeSetup.GHOST
            "normal" -> PokeTypeSetup.NORMAL
            "dark" -> PokeTypeSetup.DARK
            "fighting" -> PokeTypeSetup.FIGHTING
            "grass" -> PokeTypeSetup.GRASS
            "poison" -> PokeTypeSetup.POISON
            "dragon" -> PokeTypeSetup.DRAGON
            "fire" -> PokeTypeSetup.FIRE
            "ground" -> PokeTypeSetup.GROUND
            "psychic" -> PokeTypeSetup.PSYCHIC
            "electric" -> PokeTypeSetup.ELECTRIC
            "flying" -> PokeTypeSetup.FLYING
            "ice" -> PokeTypeSetup.ICE
            "rock" -> PokeTypeSetup.ROCK
            else -> PokeTypeSetup.NORMAL
        }
    }
}

enum class PokeTypeSetup(
        @ColorInt val colorCard: Int,
        @DrawableRes val icon: Int,
        @ColorInt val colorType: Int
) {
    BUG(R.color.bg_type_bug, R.drawable.bug, R.color.type_bug),
    WATER(R.color.bg_type_water, R.drawable.water, R.color.type_water),
    FAIRY(R.color.bg_type_fairy, R.drawable.fairy, R.color.type_fairy),
    GHOST(R.color.bg_type_ghost, R.drawable.ghost, R.color.type_ghost),
    NORMAL(R.color.bg_type_normal, R.drawable.normal, R.color.type_normal),
    DARK(R.color.bg_type_dark, R.drawable.dark, R.color.bg_type_dark),
    FIGHTING(R.color.bg_type_figthing, R.drawable.fighting, R.color.type_fighting),
    GRASS(R.color.bg_type_grass, R.drawable.grass, R.color.type_grass),
    POISON(R.color.bg_type_poison, R.drawable.poison, R.color.type_poison),
    DRAGON(R.color.bg_type_dragon, R.drawable.dragon, R.color.type_dragon),
    FIRE(R.color.bg_type_fire, R.drawable.fire, R.color.type_fire),
    GROUND(R.color.bg_type_ground, R.drawable.ground, R.color.type_ground),
    PSYCHIC(R.color.bg_type_psychic, R.drawable.psychic, R.color.type_psychic),
    ELECTRIC(R.color.bg_type_eletric, R.drawable.electric, R.color.bg_type_eletric),
    FLYING(R.color.bg_type_flying, R.drawable.flying, R.color.type_flying),
    ICE(R.color.bg_type_ice, R.drawable.ice, R.color.type_ice),
    ROCK(R.color.bg_type_rock, R.drawable.rock, R.color.type_rock),
}

