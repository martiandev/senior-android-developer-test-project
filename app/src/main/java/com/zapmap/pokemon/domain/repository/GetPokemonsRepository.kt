package com.zapmap.pokemon.domain.repository

import com.zapmap.pokemon.domain.model.PokemonResponse

abstract class GetPokemonsRepository {
    abstract suspend fun getPokemons(
        limit:Int,
        offset:Int
    ):PokemonResponse?
}