package com.kmc.pokeapp.view.main

import com.kmc.pokeapp.model.APIResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel {

    private fun getRetroFit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }
    fun getAllsPokemons(limit:Int){
        CoroutineScope(Dispatchers.IO).launch {
            var call = getRetroFit().create(APIResponse::class.java).getPokemonList("pokemon?limit=$limit&offset=0")
            var pokes = call.body()


        }
    }
}