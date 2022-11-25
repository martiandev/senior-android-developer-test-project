package com.zapmap.pokemon.data.repository

import com.zapmap.pokemon.data.datasource.PokemonItemDatasource
import com.zapmap.pokemon.domain.model.PokemonResponse
import com.zapmap.pokemon.domain.repository.GetPokemonsRepository
import javax.inject.Inject

class GetRemotePokemonsRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonItemDatasource
): GetPokemonsRepository() {
    override suspend fun getPokemons(
        limit: Int,
        offset: Int
    ): PokemonResponse? {
        return remoteDataSource.getPokemonItems(
            limit,
            offset
        )
    }
}