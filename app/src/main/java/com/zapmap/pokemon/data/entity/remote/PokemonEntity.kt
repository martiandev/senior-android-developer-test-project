package com.zapmap.pokemon.data.entity.remote

import com.zapmap.pokemon.domain.model.Pokemon
import com.zapmap.pokemon.domain.model.Sprite
import com.zapmap.pokemon.domain.model.TypeItem

class PokemonEntity (
    val name:String,
    val weight:Int,
    val height:Int,
    val types: List<TypeItem>,
    val sprites: Sprite
){
    fun toPokemon(): Pokemon {
        return Pokemon(
            name = name,
            weight = weight,
            height = height,
            types = types,
            sprites = sprites
        )
    }
}