package com.proway.pokeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.pokeapp.R
import com.proway.pokeapp.databinding.ItemPokemonBinding
import com.proway.pokeapp.model.Pokemon
import com.proway.pokeapp.utils.toUpperFirstChar

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

    @SuppressLint("ResourceType", "UseCompatLoadingForDrawables")
    fun bind(pokemon: Pokemon) {
        binding.textViewIdPokemon.text = "#${pokemon.extractIdFromUrl()}"
        binding.textViewPokemonName.text = pokemon.name
        pokemon.details?.let {
            Glide.with(itemView.context)
                .load(it.sprites?.other?.artWork?.image)
                .into(binding.imageViewPokemon)

            val pokeTypeSetup = it.type[0].type.extractBgColor()
            binding.cardView.setCardBackgroundColor(itemView.context.getColor(pokeTypeSetup.colorCard))
            binding.includeTypes.typeCardView1.setCardBackgroundColor(
                itemView.context.getColor(
                    pokeTypeSetup.colorType
                )
            )
            binding.includeTypes.typeImageView1.setImageDrawable(
                itemView.context.getDrawable(
                    pokeTypeSetup.icon
                )
            )
            binding.includeTypes.typeTextView1.text = it.type[0].type.typeName.toUpperFirstChar()

            if (it.type.size > 1) {
                val setupCard2 = it.type[1].type.extractBgColor()
                binding.includeTypes.typeCardView2.setCardBackgroundColor(
                    itemView.context.getColor(
                        setupCard2.colorType
                    )
                )
                binding.includeTypes.typeImageView2.setImageDrawable(
                    itemView.context.getDrawable(
                        setupCard2.icon
                    )
                )
                binding.includeTypes.typeTextView2.text =
                    it.type[1].type.typeName.toUpperFirstChar()
                binding.includeTypes.typeCardView2.visibility = View.VISIBLE
            } else {
                binding.includeTypes.typeCardView2.visibility = View.GONE
            }
        }
    }
}