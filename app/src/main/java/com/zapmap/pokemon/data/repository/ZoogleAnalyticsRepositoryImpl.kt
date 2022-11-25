package com.zapmap.pokemon.data.repository

import com.zapmap.pokemon.data.datasource.AnalyticsDataSource
import com.zapmap.pokemon.domain.repository.AnalyticsRepository
import javax.inject.Inject

class ZoogleAnalyticsRepositoryImpl @Inject constructor(
    private val dataSource:AnalyticsDataSource
):AnalyticsRepository(){
    override suspend fun onPokemonSelectedAnalytics(
        id: Int
    ): Boolean {
       return dataSource.onPokemonSelectedAnalytics(
           id
       )
    }
}