package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.data.datasource.PokemonItemDatasource
import com.zapmap.pokemon.domain.model.PokemonResponse
import javax.inject.Inject


class RemotePokemonItemDatasourceImpl @Inject constructor(
    private val api: PokemonApi
) :PokemonItemDatasource {

    override suspend fun getPokemonItems(
        limit: Int,
        offset: Int
    ): PokemonResponse? {
        return api.fetchPokemons(
            limit,
            offset
        ).body().let {
            when(it){
                null -> null
                else -> it.toPokemonResponse()
            }
        }

    }

}