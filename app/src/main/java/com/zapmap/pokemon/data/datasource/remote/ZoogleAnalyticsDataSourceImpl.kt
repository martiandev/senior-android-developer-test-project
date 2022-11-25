package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.BuildConfig
import com.zapmap.pokemon.ZoogleAnalytics
import com.zapmap.pokemon.ZoogleAnalyticsEvent
import com.zapmap.pokemon.data.datasource.AnalyticsDataSource
import javax.inject.Inject

class ZoogleAnalyticsDataSourceImpl @Inject constructor():AnalyticsDataSource{
    override suspend fun onPokemonSelectedAnalytics(
        id: Int
    ):Boolean {
        try {
            ZoogleAnalytics.logEvent(
                ZoogleAnalyticsEvent(
                    BuildConfig.ANALYTICS_POKEMON_SELECTED,
                    mapOf( BuildConfig.ANALYTICS_POKEMON_SELECTED_ID to id.toString())
                )
            )
            return true
        } catch (e:java.lang.Exception){
            return false
        }

    }
}