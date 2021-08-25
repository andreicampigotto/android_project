package com.proway.pokeapp.database

import android.content.Context
import androidx.room.*
import com.proway.pokeapp.database.dao.PokemonDAO
import com.proway.pokeapp.model.*

@Database(
    entities = [Pokemon::class, PokeDetails::class, Sprites::class, Other::class, ArtWork::class, Types::class, PokemonType::class],
    version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO

    companion object {

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "pokemon_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}
