package com.zapmap.pokemon.data.datasource

import com.zapmap.pokemon.domain.model.PokemonResponse

interface PokemonItemDatasource {
    suspend fun getPokemonItems(
        limit:Int,
        offset:Int
    ): PokemonResponse?
}