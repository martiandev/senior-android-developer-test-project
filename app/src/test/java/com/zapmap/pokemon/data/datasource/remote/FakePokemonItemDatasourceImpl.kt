package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.data.datasource.PokemonItemDatasource
import com.zapmap.pokemon.domain.model.PokemonResponse
import com.zapmap.pokemon.utils.PokemonResponseEntityUtil
import javax.inject.Inject

class FakePokemonItemDatasourceImpl @Inject constructor(): PokemonItemDatasource {

    override suspend fun getPokemonItems(limit: Int, offset: Int): PokemonResponse? {
        return PokemonResponseEntityUtil
            .generatePokemonResponseEntity(null)
            .toPokemonResponse()
    }
}