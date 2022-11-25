package com.zapmap.pokemon.domain.repository

import com.zapmap.pokemon.domain.model.Pokemon

abstract class GetPokemonRepository {
    abstract suspend fun getPokemon(
        id:Int,
    ):Pokemon?
}