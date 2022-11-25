package com.zapmap.pokemon.domain.repository

abstract class AnalyticsRepository {

    abstract suspend fun onPokemonSelectedAnalytics(
        id:Int
    ):Boolean

}