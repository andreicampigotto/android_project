package com.proway.pokeapp.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.pokeapp.database.AppDatabase
import com.proway.pokeapp.model.PokeDetails
import com.proway.pokeapp.model.Pokemon
import com.proway.pokeapp.model.Sprites
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class PokemonDAOTest {
    private lateinit var database: AppDatabase
    private lateinit var dao: PokemonDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.pokemonDAO()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun test_insert_need_return_true() {

        val pokemonToInsert = Pokemon("pikachu", "", PokeDetails(0, Sprites(0, null), emptyList()))

        dao.insert(pokemonToInsert)
        val returnedPokes = dao.all()
        assertThat(returnedPokes).contains(pokemonToInsert)
    }

    @Test
    fun test_select_like() {

        val poke1 =
            Pokemon("botao", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke1)

        val poke2 =
            Pokemon("botao", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke2)

        val poke3 =
            Pokemon("botao", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke3)


        val returnedPokes = dao.fetchFiltered("ao")
        assertThat(returnedPokes).hasSize(1)
    }

    @Test
    fun fetch_by_id() {

        val poke1 =
            Pokemon("botao", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke1)

        val poke2 =
            Pokemon("andrei", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke2)

        val poke3 =
            Pokemon("arthur", "", PokeDetails(0, Sprites(0, null), emptyList()))
        dao.insert(poke3)


        val returnedPokes = dao.getById("arthur")
        assertThat(returnedPokes).isEqualTo(poke3)
    }

}