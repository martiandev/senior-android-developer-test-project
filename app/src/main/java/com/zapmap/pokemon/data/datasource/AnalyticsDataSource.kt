package com.zapmap.pokemon.data.datasource

interface AnalyticsDataSource {
    suspend fun onPokemonSelectedAnalytics(
        id:Int
    ):Boolean
}