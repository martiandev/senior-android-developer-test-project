package com.zapmap.pokemon.domain.usecase

import com.zapmap.pokemon.domain.repository.AnalyticsRepository
import javax.inject.Inject

class PokemonSelectedAnalyticsUseCase @Inject constructor(
    private val repository: AnalyticsRepository
) {
    suspend operator fun invoke(id:Int): Boolean{
        return repository.
        onPokemonSelectedAnalytics(id)
    }
}