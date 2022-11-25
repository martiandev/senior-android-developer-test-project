package com.zapmap.pokemon.utils

import com.zapmap.pokemon.data.entity.remote.PokemonItemEntity
import com.zapmap.pokemon.data.entity.remote.PokemonResponseEntity

object PokemonResponseEntityUtil {
    val item1 = PokemonItemEntity("bulbasaur","https://pokeapi.co/api/v2/pokemon/1/")
    val item2 = PokemonItemEntity("ivysaur","https://pokeapi.co/api/v2/pokemon/2/")
    val item3 = PokemonItemEntity("venusaur","https://pokeapi.co/api/v2/pokemon/3/")

    fun generatePokemonResponseEntity(next:String?): PokemonResponseEntity {
        var list:List<PokemonItemEntity> = listOf(
            item1,
            item2,
            item3
        )
        var pokemonResponseEntity = PokemonResponseEntity(
            next,
            list
        )
        return pokemonResponseEntity
    }

}