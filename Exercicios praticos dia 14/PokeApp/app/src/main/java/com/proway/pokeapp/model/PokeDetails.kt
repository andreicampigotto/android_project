package com.proway.pokeapp.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PokeDetails(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "detail_id")
    val id: Int,

    @Embedded
    @SerializedName("sprites")
    val sprites: Sprites?
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

