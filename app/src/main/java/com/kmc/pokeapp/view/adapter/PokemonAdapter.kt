package com.kmc.pokeapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmc.pokeapp.model.Pokemon
import com.kmc.pokeapp.R

class PokemonAdapter(private val pokList: List<Pokemon>): RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount() = pokList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        var item = pokList[position]
        holder.print(item)
    }
}