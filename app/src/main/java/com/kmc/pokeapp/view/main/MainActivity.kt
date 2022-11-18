package com.kmc.pokeapp.view.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmc.pokeapp.model.APIResponse
import com.kmc.pokeapp.databinding.ActivityMainBinding
import com.kmc.pokeapp.model.Pokemon
import com.kmc.pokeapp.model.Pokemones
import com.kmc.pokeapp.view.adapter.PokemonAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var pokadapter : PokemonAdapter
    private var pokemonList = mutableListOf<Pokemon>()
    private lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        context = this
        initPokemonReclycler()
    }
    private fun initPokemonReclycler(){
        pokadapter = PokemonAdapter(pokemonList)
        main.rcvPokemon.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pokadapter
        }
    }

    private fun getRetroFit():Retrofit{
        return Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getAllsPokemons(limit:Int){
        CoroutineScope(Dispatchers.IO).launch {
            var call = getRetroFit().create(APIResponse::class.java).getPokemonList("pokedex.json")
            var pokes = call.body()
            runOnUiThread {
                if (call.isSuccessful){
                    Toast.makeText(context,"Ha Ocurrido un Error :(", Toast.LENGTH_SHORT).show()
                    var pokemons = pokes?.pokemonList ?: emptyList()
                    pokemonList.clear()
                    pokemonList.addAll(pokemons)
                    pokadapter.notifyDataSetChanged()
                }
                else{ showError()}
            }

        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha Ocurrido un Error :(", Toast.LENGTH_SHORT).show()
    }
}