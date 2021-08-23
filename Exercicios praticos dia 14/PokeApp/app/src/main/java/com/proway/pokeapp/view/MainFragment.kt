package com.proway.pokeapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.pokeapp.R
import com.proway.pokeapp.adapter.PokemonAdapter
import com.proway.pokeapp.databinding.MainFragmentBinding
import com.proway.pokeapp.model.Pokemon
import com.proway.pokeapp.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val adapter = PokemonAdapter()

    private val observerPokemons= Observer<List<Pokemon>>{ pokemons ->
        adapter.update(pokemons)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.pokemonRecyclerView.adapter = adapter

        viewModel.pokemons.observe(viewLifecycleOwner, observerPokemons)
        viewModel.fetchAllFromDatabase(requireContext())
    }
}