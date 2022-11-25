package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.data.datasource.PokemonDatasource
import com.zapmap.pokemon.domain.model.Pokemon
import javax.inject.Inject


class RemotePokemonDatasourceImpl @Inject constructor(
    private val api: PokemonApi
) :PokemonDatasource {

    override suspend fun getPokemon(id: Int): Pokemon? {
        return  api.fetchPokemonById(
            id
        ).body().let { entity ->
            when(entity){
                null -> null
                else -> entity.toPokemon()
            }
        }
    }
}