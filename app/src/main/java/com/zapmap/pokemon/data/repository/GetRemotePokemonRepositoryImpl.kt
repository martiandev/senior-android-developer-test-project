package com.zapmap.pokemon.data.repository

import com.zapmap.pokemon.data.datasource.PokemonDatasource
import com.zapmap.pokemon.domain.model.Pokemon
import com.zapmap.pokemon.domain.repository.GetPokemonRepository
import javax.inject.Inject

class GetRemotePokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonDatasource
): GetPokemonRepository() {

    override suspend fun getPokemon(
        id: Int
    ): Pokemon? {
        return remoteDataSource.getPokemon(
            id
        )
    }
}