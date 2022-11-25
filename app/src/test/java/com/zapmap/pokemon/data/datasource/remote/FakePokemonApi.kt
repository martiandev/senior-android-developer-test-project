package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.data.entity.remote.PokemonEntity
import com.zapmap.pokemon.data.entity.remote.PokemonResponseEntity
import com.zapmap.pokemon.utils.PokemonResponseEntityUtil.generatePokemonResponseEntity
import retrofit2.Response
import javax.inject.Inject

class FakePokemonApi @Inject constructor():PokemonApi {
    val next = "https://pokeapi.co/api/v2/pokemon?offset=3&limit=3"

    override suspend fun fetchPokemons(limit: Int, offset: Int): Response<PokemonResponseEntity> {
        return Response.success(
            generatePokemonResponseEntity(next)
        )
    }

    override suspend fun fetchPokemonById(id: Int): Response<PokemonEntity> {
        TODO("Not yet implemented")
    }
}