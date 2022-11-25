package com.zapmap.pokemon.domain.repository

import com.zapmap.pokemon.domain.model.PokemonResponse
import com.zapmap.pokemon.utils.PokemonResponseEntityUtil
import javax.inject.Inject

class FakeGetPokemonsRepository @Inject constructor(): GetPokemonsRepository() {


    override suspend fun getPokemons(limit: Int, offset: Int): PokemonResponse? {
       return PokemonResponseEntityUtil
           .generatePokemonResponseEntity(null)
           .toPokemonResponse()
    }
}