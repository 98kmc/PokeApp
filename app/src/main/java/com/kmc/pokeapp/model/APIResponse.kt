package com.kmc.pokeapp.model

import retrofit2.Response
import retrofit2.http.Url

interface APIResponse {
    fun getPokemonList(@Url url:String): Response<Pokemones>
}