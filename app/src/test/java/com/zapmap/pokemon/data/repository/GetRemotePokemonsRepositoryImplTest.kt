package com.zapmap.pokemon.data.repository

import com.google.common.truth.Truth
import com.zapmap.pokemon.data.datasource.remote.FakePokemonItemDatasourceImpl
import com.zapmap.pokemon.domain.model.PokemonResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetRemotePokemonsRepositoryImplTest{

    lateinit var repository: GetRemotePokemonsRepositoryImpl

    @Before
    fun seUp(){
        repository =  GetRemotePokemonsRepositoryImpl(FakePokemonItemDatasourceImpl())
    }
    @Test
    fun `should be able to get Response PokemonItemEntity` () = runBlocking {
        var  result  = repository.getPokemons(3,3)
        Truth.assertThat(result)
            .isInstanceOf(PokemonResponse::class.java)
    }
    @Test
    fun `should be able to get Response PokemonItemEntity withr 3 items` () = runBlocking {
        var  result  = repository.getPokemons(3,3)
        Truth.assertThat(result?.pokemonItems?.size)
            .isEqualTo(3)
    }
}