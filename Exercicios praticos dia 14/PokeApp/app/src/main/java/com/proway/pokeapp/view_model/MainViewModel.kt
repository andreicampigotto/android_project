package com.proway.pokeapp.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.pokeapp.model.Pokemon
import com.proway.pokeapp.repository.PokemonRepository

class MainViewModel : ViewModel() {

    val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private fun fetchAllFromServer(context: Context) {
        val repository = PokemonRepository(context)

        repository.fetchAll { response, error ->
            response?.let {
                _pokemons.value = it.results
                loadPokemonDetails(it.results, repository)
            }
            error?.let {
                _error.value = it
            }
        }
    }

    private fun loadPokemonDetails(pokemons: List<Pokemon>, repository: PokemonRepository) {
        pokemons.forEach { poke ->
            repository.fetchPokemonDetails(pokeId = poke.extractIdFromUrl()) { details, _ ->
                details?.let {
                    poke.details = details
                    repository.insertIntoDatabase(poke)
                }
            }
        }
    }

    fun fetchAllFromDatabase(context: Context) {
        val listOf = PokemonRepository(context).fetchAllFromDatabase()
        if (listOf != null && listOf.isNotEmpty())
            _pokemons.value = listOf!!
        else
            fetchAllFromServer(context)
    }

    fun fetchFilteredFromDatabase(context: Context, query: String){
        val repository = PokemonRepository(context)
        val filtredList = repository.fetchAllFromDatabaseWithFilter(query)
        filtredList?.let {
            _pokemons.value = it
        }
    }
}