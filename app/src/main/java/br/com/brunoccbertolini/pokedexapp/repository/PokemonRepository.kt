package br.com.brunoccbertolini.pokedexapp.repository

import br.com.brunoccbertolini.pokedexapp.data.remote.PokeApi
import br.com.brunoccbertolini.pokedexapp.data.remote.responses.Pokemon
import br.com.brunoccbertolini.pokedexapp.data.remote.responses.PokemonList
import br.com.brunoccbertolini.pokedexapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception){
            return Resource.Error(message = "An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(name = pokemonName)
        } catch (e: Exception){
            return Resource.Error(message = "An unknown error occured.")
        }
        return Resource.Success(response)
    }

}