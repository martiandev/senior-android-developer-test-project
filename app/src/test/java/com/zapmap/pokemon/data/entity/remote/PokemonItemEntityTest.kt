package com.zapmap.pokemon.data.entity.remote

import com.google.common.truth.Truth
import org.junit.Test

internal class PokemonItemEntityTest{

    val name = "Bulbasaur"
    val url = "www.google.com"

    fun generatePokemonItemEntity():PokemonItemEntity{
        return PokemonItemEntity(
         name,
         url
        )
    }

    @Test
    fun `Should be able to yield a Pokemon Item with the same name`(){
        var pokemonItem = generatePokemonItemEntity().toPokemonItem()
        Truth.assertThat(pokemonItem.name).isEqualTo(name)
    }
    @Test
    fun `Should be able to yield a Pokemon Item with the same url`(){
        var pokemonItem = generatePokemonItemEntity().toPokemonItem()
        Truth.assertThat(pokemonItem.url).isEqualTo(url)
    }

}