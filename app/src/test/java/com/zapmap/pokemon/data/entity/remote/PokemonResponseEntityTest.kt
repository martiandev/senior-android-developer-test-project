package com.zapmap.pokemon.data.entity.remote

import com.google.common.truth.Truth
import com.zapmap.pokemon.utils.PokemonResponseEntityUtil.generatePokemonResponseEntity
import org.junit.Test

internal class PokemonResponseEntityTest{

    val next = "https://pokeapi.co/api/v2/pokemon?offset=3&limit=3"

    @Test
    fun `Should be able to yield a PokemonResponse with same next`(){
        var pokemonResponse = generatePokemonResponseEntity(next)
            .toPokemonResponse()
        Truth.assertThat(pokemonResponse?.next).isEqualTo(next)
    }
    @Test
    fun `Should be able to yield a PokemonResponse with offset of 3`(){
        var pokemonResponse = generatePokemonResponseEntity(next)
            .toPokemonResponse()
        Truth.assertThat(pokemonResponse?.offset).isEqualTo(3)
    }
    @Test
    fun `Should be able to yield a PokemonResponse with limit of 3`(){
        var pokemonResponse = generatePokemonResponseEntity(next)
            .toPokemonResponse()
        Truth.assertThat(pokemonResponse?.limit).isEqualTo(3)
    }
    @Test
    fun `Should be able to yield a PokemonResponse with 3 PokemonItems`(){
        var pokemonResponse = generatePokemonResponseEntity(next)
            .toPokemonResponse()
        Truth.assertThat(pokemonResponse?.pokemonItems?.size).isEqualTo(3)
    }


}