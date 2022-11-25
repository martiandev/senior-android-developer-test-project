package com.zapmap.pokemon.data.entity.remote

import com.zapmap.pokemon.domain.model.PokemonItem

data class PokemonItemEntity (
    val name:String,
    val url:String
) {
    fun toPokemonItem():PokemonItem{
        return PokemonItem(
            name,
            url
        )
    }
}
