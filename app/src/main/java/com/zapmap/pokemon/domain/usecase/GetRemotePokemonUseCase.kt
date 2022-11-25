package com.zapmap.pokemon.domain.usecase

import com.zapmap.pokemon.domain.model.Pokemon
import com.zapmap.pokemon.domain.repository.GetPokemonRepository
import javax.inject.Inject

class GetRemotePokemonUseCase @Inject constructor(
    private val repository: GetPokemonRepository
) {
    suspend operator fun invoke(id:Int): Pokemon? {
        return repository.getPokemon(id)
    }
}