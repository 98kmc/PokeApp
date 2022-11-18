package com.kmc.pokeapp.view.adapter

import android.view.View
import android.widget.Toast
import androidx.lifecycle.viewmodel.CreationExtras.Empty.get
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kmc.pokeapp.model.Pokemon
import com.kmc.pokeapp.databinding.ItemPokemonBinding
import com.squareup.picasso.*

class PokemonViewHolder(view : View) : ViewHolder(view){
    private val item_pokemon = ItemPokemonBinding.bind(view)
    fun print( pokemon: Pokemon)
    {
        Picasso.get().load(pokemon.img).into(item_pokemon.ivPok)
        item_pokemon.tvPokName.text = pokemon.nombre

    }

}