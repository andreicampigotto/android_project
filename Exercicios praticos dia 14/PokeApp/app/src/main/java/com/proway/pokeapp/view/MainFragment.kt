package com.proway.pokeapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
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

        binding.textFildSearch.editText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let{
                    if (it.length > 2)
                        viewModel.fetchFilteredFromDatabase(requireContext(), it.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if (it.isEmpty())
                        viewModel.fetchAllFromDatabase(requireContext())
                }
            }
        })

        binding.filterButton.setOnClickListener{showBottomSheetDialog()}
    }

    fun showBottomSheetDialog(){
        val bottomSheet = FilterFragment.newInstance()
        bottomSheet.show(parentFragmentManager, "dialog_filters")
    }
}