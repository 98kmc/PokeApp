package com.kmc.pokeapp.model

import com.google.gson.annotations.SerializedName

data class Pokemones (
    @SerializedName("pokemon") val pokemonList: List<Pokemon>)