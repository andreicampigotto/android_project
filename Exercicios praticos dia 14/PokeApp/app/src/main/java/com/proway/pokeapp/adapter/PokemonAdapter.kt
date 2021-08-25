package com.proway.pokeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pokeapp.R
import com.proway.pokeapp.databinding.ItemPokemonBinding
import com.proway.pokeapp.model.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonViewHolder>() {

    private var pokemons = mutableListOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false).apply {
            return PokemonViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        pokemons[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = pokemons.size

    fun update(newlist: List<Pokemon>) {
        pokemons.clear()
        pokemons.addAll(newlist)
        notifyDataSetChanged()
    }
}

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemPokemonBinding = ItemPokemonBinding.bind(itemView)

    fun bind(pokemon: Pokemon) {
        binding.textViewIdPokemon.text = "#${pokemon.extractIdFromUrl()}"
        binding.textViewPokemonName.text = pokemon.name
        pokemon.details?.let {
            Glide.with(itemView.context)
                .load(it.sprites?.other?.artWork?.image)
                .into(binding.imageViewPokemon)

            val pokeTypeSetup = it.type[0].type.extractBgColor()
            binding.cardView.setCardBackgroundColor(itemView.context.getColor(pokeTypeSetup))
        }
    }
}