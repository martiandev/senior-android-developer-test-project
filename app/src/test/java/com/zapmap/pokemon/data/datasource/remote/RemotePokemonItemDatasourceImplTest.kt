package com.zapmap.pokemon.data.datasource.remote

import com.google.common.truth.Truth
import com.zapmap.pokemon.domain.model.PokemonResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class RemotePokemonItemDatasourceImplTest{

    lateinit var datasource: RemotePokemonItemDatasourceImpl

    @Before
    fun seUp(){
        datasource =  RemotePokemonItemDatasourceImpl(FakePokemonApi())
    }

    @Test
    fun `should be able to get Response PokemonItemEntity` () = runBlocking {
       var  result  = datasource.getPokemonItems(3,3)
        Truth.assertThat(result)
            .isInstanceOf(PokemonResponse::class.java)
    }
    @Test
    fun `should be able to get Response PokemonItemEntity withr 3 items` () = runBlocking {
        var  result  = datasource.getPokemonItems(3,3)
        Truth.assertThat(result?.pokemonItems?.size)
            .isEqualTo(3)
    }

}
