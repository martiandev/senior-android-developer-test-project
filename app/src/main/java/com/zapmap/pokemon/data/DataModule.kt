package com.zapmap.pokemon.data

import com.zapmap.pokemon.data.datasource.AnalyticsDataSource
import com.zapmap.pokemon.data.datasource.PokemonDatasource
import com.zapmap.pokemon.data.datasource.PokemonItemDatasource
import com.zapmap.pokemon.data.datasource.remote.RemotePokemonDatasourceImpl
import com.zapmap.pokemon.data.datasource.remote.RemotePokemonItemDatasourceImpl
import com.zapmap.pokemon.data.datasource.remote.ZoogleAnalyticsDataSourceImpl
import com.zapmap.pokemon.data.repository.GetRemotePokemonRepositoryImpl
import com.zapmap.pokemon.data.repository.GetRemotePokemonsRepositoryImpl
import com.zapmap.pokemon.data.repository.ZoogleAnalyticsRepositoryImpl
import com.zapmap.pokemon.domain.repository.AnalyticsRepository
import com.zapmap.pokemon.domain.repository.GetPokemonRepository
import com.zapmap.pokemon.domain.repository.GetPokemonsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    abstract fun bindsGetPokemonsRepository(
        getPokemonRepo: GetRemotePokemonsRepositoryImpl
    ): GetPokemonsRepository

    @Binds
    @Singleton
    abstract fun bindsGetPokemonRepository(
        getPokemonRepo: GetRemotePokemonRepositoryImpl
    ): GetPokemonRepository


    @Binds
    @Singleton
    abstract fun bindsAnalyticsDataSource(
        analytics: ZoogleAnalyticsRepositoryImpl
    ): AnalyticsRepository


    @Binds
    @Singleton
    abstract fun bindsRemotePokemonItemDataSource(
        remoteDataSource: RemotePokemonItemDatasourceImpl
    ): PokemonItemDatasource

    @Binds
    @Singleton
    abstract fun bindsRemotePokemonDataSource(
        remoteDataSource: RemotePokemonDatasourceImpl
    ): PokemonDatasource

    @Binds
    @Singleton
    abstract fun bindsZoogleAnalyticsDataSource(
        remoteDataSource: ZoogleAnalyticsDataSourceImpl
    ): AnalyticsDataSource
}
