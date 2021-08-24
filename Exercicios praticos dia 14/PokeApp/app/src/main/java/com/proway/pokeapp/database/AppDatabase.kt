package com.proway.pokeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.pokeapp.database.dao.PokemonDAO
import com.proway.pokeapp.model.*

@Database(
    entities = [Pokemon::class, PokeDetails::class, Sprites::class, Other::class, ArtWork::class],
    version = 1)
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
