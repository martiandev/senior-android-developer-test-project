package com.zapmap.pokemon.data.datasource

import com.zapmap.pokemon.domain.model.Pokemon

interface PokemonDatasource {
    suspend fun getPokemon(
        id: Int,
    ): Pokemon?
}