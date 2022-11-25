package com.zapmap.pokemon.domain.usecase

import com.zapmap.pokemon.domain.model.PokemonResponse
import com.zapmap.pokemon.domain.repository.GetPokemonsRepository
import javax.inject.Inject

class GetRemotePokemonsUseCase @Inject constructor(
    private val repository: GetPokemonsRepository
 ) {
    suspend operator fun invoke(
        limit:Int,
        offset:Int
    ): PokemonResponse? {
        return repository.getPokemons(limit,offset)
    }
}