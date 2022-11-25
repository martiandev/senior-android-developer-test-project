package com.zapmap.pokemon.data.entity.remote

import com.google.common.truth.Truth
import com.zapmap.pokemon.domain.model.Sprite
import com.zapmap.pokemon.domain.model.TypeItem
import org.junit.Test

internal class PokemonEntityTest{

    val name = "Bulbasaur"
    val weight = 1
    val height = 2
    val types = listOf<TypeItem>()
    val sprites = Sprite(frontDefault = "image")

    fun generatePokemonEntity():PokemonEntity{
        return PokemonEntity(
            name,
            weight,
            height,
            types,
            sprites
        )
    }
    @Test
    fun `Should be able to yield a Pokemon with same name`(){
        var pokemon = generatePokemonEntity().toPokemon()
        Truth.assertThat(pokemon.name).isEqualTo(name)
    }
    @Test
    fun `Should be able to yield a Pokemon with same weight`(){
        var pokemon = generatePokemonEntity().toPokemon()
        Truth.assertThat(pokemon.weight).isEqualTo(weight)
    }
    @Test
    fun `Should be able to yield a Pokemon with same height`(){
        var pokemon = generatePokemonEntity().toPokemon()
        Truth.assertThat(pokemon.height).isEqualTo(height)
    }
    @Test
    fun `Should be able to yield a Pokemon with no types`(){

        var pokemon = generatePokemonEntity().toPokemon()
        Truth.assertThat(types.size).isEqualTo(0)
    }
    @Test
    fun `Should be able to yield a Pokemon with sprite whose url is image`(){

        var pokemon = generatePokemonEntity().toPokemon()
        Truth.assertThat(pokemon.sprites.frontDefault).isEqualTo("image")
    }

}